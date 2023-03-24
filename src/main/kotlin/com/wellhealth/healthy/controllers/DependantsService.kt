package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Dependants
import com.wellhealth.healthy.dataclasses.Users
import com.wellhealth.healthy.repositories.DependantsRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@RestController
class DependantsService (val dependantsRepository: DependantsRepository) {
    @GetMapping("/getDependantsbyParentID/{parentid}")
    @ApiOperation(value = "Get all the dependants", notes = "Get all The users ")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
     fun getDependants(@PathVariable parentid:Int):ResponseEntity<List<Dependants>> {
        val depArray = dependantsRepository.findAllpolicybeneficiaryByparentid(parentid)
        return ResponseEntity.ok(depArray)

    }
}