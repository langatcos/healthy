package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.UserRepository
import com.wellhealth.healthy.dataclasses.Users
import io.swagger.annotations.ApiOperation
import org.mindrot.jbcrypt.BCrypt
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Instant
import javax.persistence.EntityNotFoundException

@RestController
internal class UserService (val user : UserRepository) {
    @GetMapping("/getAllUsers")
    @ApiOperation(value = "Get all the users", notes = "Get all The users ")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun index(): List<Users>{
        return user.getAllUsers()
    }
    @GetMapping("/getUser/{username}")
    @ApiOperation(value = "Get User by Username", notes = "Get the details about the user by supplying the Username")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getUsers(@PathVariable username: String): ResponseEntity<List<Users>> {
        val userDetails = user.findAllByusername(username)
        return if (userDetails != null) {
            ResponseEntity.ok(userDetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @GetMapping("/checkEntityid/{entityid}")
    @ApiOperation(value = "Check if user exist", notes = "Check if user Exist")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun checkExistingUser(@PathVariable entityid:Int): ResponseEntity<List<Users>>{
        val existinguser=user.findAllByentityid(entityid)
        return if (existinguser !=null){
            ResponseEntity.ok(existinguser)
        }else{
            ResponseEntity.notFound().build()

        }
    }

    @PostMapping("/addusers")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    @ApiOperation(value = "Add New User into the db", notes = "Add user into the db")
    fun createUser(@RequestBody users: Users): ResponseEntity<Users> {
        // Hash the password before saving
        val date_created= Instant.now()
        val hashedPassword = BCrypt.hashpw(users.userpwd, BCrypt.gensalt())
        val newUser = Users(null,users.entityid, users.firstname, users.surname, users.username,users.dob,users.gender,users.active,users.branch,date_created,hashedPassword)
        val savedUser = user.save(newUser)
        return ResponseEntity.ok(savedUser)
    }
    @DeleteMapping("/deleteuser/{userid}")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    @ApiOperation(value = "Delete User", notes = "Delete User")
    fun deleteuser(@PathVariable userid:Int) :ResponseEntity <Void> {
        val userto_delete=user.findUserByuserid(userid)
        return if (userto_delete !=null){
            user.delete(userto_delete)
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }


    }
    @PutMapping("/disableuser/{userid}")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    @ApiOperation(value = "Make user Inactive", notes = "Make User Inactive")
    fun updateUser(@PathVariable userid:Int,@RequestBody users: Users): Users {

        val existingUser=user.findUserByuserid(userid)
        if(existingUser==null){
            throw EntityNotFoundException("User with ID $userid not found")
        }
        existingUser.apply {
            active = users.active

            // Update other properties as needed
        }
        return user.save(existingUser)

    }

}