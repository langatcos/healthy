package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.ClaimsCategories
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ClaimsCategoriesRepository: CrudRepository<ClaimsCategories,String> {
    @Query("select * from claimscategoies")
    fun findAllCategoriesbybeneficiaryid(beneficiaryid:Int):List<ClaimsCategories>

}