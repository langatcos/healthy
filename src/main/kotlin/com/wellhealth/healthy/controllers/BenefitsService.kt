package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.BenefitCategory
import com.wellhealth.healthy.dataclasses.BenefitDetails
import com.wellhealth.healthy.dataclasses.Benefits
import com.wellhealth.healthy.dataclasses.ClaimsDetails
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
    fun getBenefits(@PathVariable policyid:Int,@PathVariable effectivedate:String):ResponseEntity<List<BenefitDetails>>{
     return benefit.getPolicyBenefits(policyid,effectivedate).run {
         if(isEmpty()){
             ResponseEntity.notFound().build()
         }
         else{
             ResponseEntity.ok(groupBy { it.benefitid }.map {
                 val (benefitid,groupList)=it
                 BenefitDetails(
                     groupList[0].policyid,
                     groupList[0].effectivedate,
                     groupList.map { BenefitCategory(it.benefitid,it.benefitname,it.distribution,it.limit) }
                 )


             })
         }
     }
    /* val benefits=benefit.getPolicyBenefits(policyid,effectivedate)
        return if(benefit !=null){
            ResponseEntity.ok(benefits)
        }else{
            ResponseEntity.notFound().build()
        }*/
    }
}