package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.ClaimsDetailsRepository
import com.wellhealth.healthy.services.ClaimsDetails
import com.wellhealth.healthy.services.Users
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ClaimsDetailsService (val claims:ClaimsDetailsRepository) {

    @GetMapping("/getclaimsdetailsbyid/{beneficiaryid}")
    @ApiOperation(value = "Get Claims by Beneficiaryid", notes = "Query all claims by Beneficciaryid")

    fun getclaimsdetailsbyId(@PathVariable beneficiaryid: Int): ResponseEntity<List<ClaimsDetails>> {
        val claimsdetails = claims.getAllclaimsdetailsbyId(beneficiaryid)
        return if (claimsdetails != null) {
            ResponseEntity.ok(claimsdetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}