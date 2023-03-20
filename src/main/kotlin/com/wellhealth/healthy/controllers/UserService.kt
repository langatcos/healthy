package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.UserRepository
import com.wellhealth.healthy.services.Users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class UserService (val user:UserRepository) {
    @GetMapping("/getAllUsers")
    fun index(): List<Users>{
        return user.getAllUsers()
    }


}