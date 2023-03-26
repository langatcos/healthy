package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.ClaimsCategories
import com.wellhealth.healthy.repositories.ClaimsCategoriesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ClaimsCategoriesService (val category : ClaimsCategoriesRepository) {
    @GetMapping("/getclaimscategories/{beneficiaryid}")

    fun getCategories(@PathVariable beneficiaryid:Int):ResponseEntity<List<ClaimsCategories>>{
        val claimscategories = category.findAllCategoriesbybeneficiaryid(beneficiaryid)
        return if (claimscategories !=null){
            ResponseEntity.ok(claimscategories)
        }else{
            ResponseEntity.notFound().build()
        }
    }

}