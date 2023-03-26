package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Benefits
import com.wellhealth.healthy.repositories.BenefitsRepositoy
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BenefitsService (val benefit :BenefitsRepositoy) {
    @GetMapping("/getbenefits/{policyid}/{effectivedate}")
    @ApiOperation(value="get Policy benefits",notes="Get Policy benefits by supplying the policyid and effectivedate")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getBenefits(@PathVariable policyid:Int,@PathVariable effectivedate:String):ResponseEntity<List<Benefits>>{
     return benefit.getPolicyBenefits(policyid,effectivedate).map {
         if(isE)
     }
    /* val benefits=benefit.getPolicyBenefits(policyid,effectivedate)
        return if(benefit !=null){
            ResponseEntity.ok(benefits)
        }else{
            ResponseEntity.notFound().build()
        }*/
    }
}