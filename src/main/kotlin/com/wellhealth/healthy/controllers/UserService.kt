package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.UserRepository
import com.wellhealth.healthy.services.Users
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
internal class UserService (val user : UserRepository) {
    @GetMapping("/getAllUsers")
    @ApiOperation(value = "Get all the users", notes = "Get all The users from the db")

    fun index(): List<Users>{
        return user.getAllUsers()
    }
    @GetMapping("/getUser/{username}")
    @ApiOperation(value = "Get User by Username", notes = "Get the details about the user by supplying the Username")
    fun getUsers(@PathVariable username: String): ResponseEntity<List<Users>> {
        val userDetails = user.findAllByusername(username)
        return if (userDetails != null) {
            ResponseEntity.ok(userDetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}