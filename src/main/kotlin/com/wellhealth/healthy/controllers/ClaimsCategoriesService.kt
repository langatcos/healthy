package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Categories
import com.wellhealth.healthy.dataclasses.ClaimsCategories
import com.wellhealth.healthy.dataclasses.InvoiceBenefits
import com.wellhealth.healthy.repositories.ClaimsCategoriesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ClaimsCategoriesService (val category : ClaimsCategoriesRepository) {
    @GetMapping("/getclaimscategories/{beneficiaryid}")

    fun getCategories(@PathVariable beneficiaryid:Int):ResponseEntity<List<InvoiceBenefits>>{
           return category.findAllCategoriesbybeneficiaryid(beneficiaryid).run {
           if(isEmpty()){
               ResponseEntity.notFound().build()
           }
           else{
               ResponseEntity.ok(groupBy { it.invoicebenefit }.map {
                   val (beneficiaryid,groupList)=it
                   InvoiceBenefits(
                       groupList[0].invoicebenefit,
                       groupList[0].beneficiaryid,
                       groupList[0].policyid,
                       groupList[0].effectivedate,
                       groupList.map { Categories(it.invoicetype,it.settledamount) }
                   )
               })
           }
       }
    /* return if (claimscategories !=null){
            ResponseEntity.ok(claimscategories)
        }else{
            ResponseEntity.notFound().build()
        }*/
    }

}