package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.UserRepository
import com.wellhealth.healthy.services.Users
import io.swagger.annotations.ApiOperation
import org.mindrot.jbcrypt.BCrypt
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

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
    @PostMapping("/addusers")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    @ApiOperation(value = "Add New User into the db", notes = "Add user into the db")
    fun createUser(@RequestBody users: Users): ResponseEntity<Users> {
        // Hash the password before saving
        val hashedPassword = BCrypt.hashpw(users.userpwd, BCrypt.gensalt())
        val newUser = Users(null,users.entityid, users.firstname, users.surname, users.username,users.dob,users.gender,users.active,users.branch,null,hashedPassword)
        val savedUser = user.save(newUser)
        return ResponseEntity.ok(savedUser)
    }
}