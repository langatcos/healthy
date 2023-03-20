package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.UserRepository
import com.wellhealth.healthy.services.Users
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
internal class UserService (val user : UserRepository) {
    @GetMapping("/getAllUsers")
    fun index(): List<Users>{
        return user.getAllUsers()
    }
    @GetMapping("/getUser/{username}")
    fun getUsers(@PathVariable username: String): ResponseEntity<List<Users>> {
        val userDetails = user.findAllByusername(username)
        return if (userDetails != null) {
            ResponseEntity.ok(userDetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}