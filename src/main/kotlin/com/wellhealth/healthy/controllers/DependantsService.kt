package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Dependants
import com.wellhealth.healthy.dataclasses.Users
import com.wellhealth.healthy.repositories.DependantsRepository
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
class DependantsService (val dependantsRepository: DependantsRepository) {
    @GetMapping("/getAllDependants")
    @ApiOperation(value = "Get all the dependants", notes = "Get all The users ")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun index(): List<Dependants>{
        return dependantsRepository.getAllDependants()
    }
}