package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.repositories.ClaimsDetailsRepository
import com.wellhealth.healthy.dataclasses.ClaimsDetails
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class ClaimsDetailsService (val claims:ClaimsDetailsRepository) {

    @GetMapping("/getclaimsdetailsbyid/{beneficiaryid}")
    @ApiOperation(value = "Get Claims by Beneficiaryid", notes = "Query all claims by Beneficciaryid")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getclaimsdetailsbyId(@PathVariable beneficiaryid: Int,  response :HttpServletResponse): ResponseEntity<List<ClaimsDetails>> {
        val claimsdetails = claims.getAllBybeneficiarid(beneficiaryid)
        response.setHeader("Access-Control-Allow-Credentials", "true") // Add the header to the response

        return if (claimsdetails != null) {
            ResponseEntity.ok(claimsdetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
