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
class ClaimsDetailsService (val claims :ClaimsDetailsRepository) {

    @GetMapping("/getClaimsBybeneficiaryid/{beneficiaryid}")
    @ApiOperation(value = "Get Claims by Beneficiaryid", notes = "Query all claims by Beneficciaryid")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getClaimsByBeneficiaryid(@PathVariable beneficiaryid: Int): ResponseEntity<List<ClaimsDetails>> {
        val claimsdetails = claims.findClaimsByBeneficiaryid(beneficiaryid)

        return if (claimsdetails != null) {
            ResponseEntity.ok(claimsdetails)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @GetMapping("/getclaimsbybenefitid/{benefitid}/{beneficiaryid}/{policyid}/{effectivedate}")
    @ApiOperation(value="Get Claims By benefitid", notes="Get Claims By benefitid")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getClaimsbyBenefitid (@PathVariable benefitid:Int, @PathVariable beneficiaryid:Int,@PathVariable policyid:Int, @PathVariable effectivedate:String):ResponseEntity<List<ClaimsDetails>>{
        val claimbybId=claims.findAllByBenefitidAndBeneficiaryidAndPolicyidAndEffectivedate (benefitid,beneficiaryid,policyid,effectivedate)
        return if(claimbybId !=null){
            ResponseEntity.ok(claimbybId)
        }else{
            ResponseEntity.notFound().build()
        }
    }
}
