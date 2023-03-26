package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.Benefits
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface BenefitsRepositoy:CrudRepository<Benefits,String> {
    @Query("select random() as id,* from benefits")
    fun getPolicyBenefits(policyid:Int,effectivedate:String):List<Benefits>
}