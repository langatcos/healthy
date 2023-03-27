package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.ClaimsDetails
import com.wellhealth.healthy.dataclasses.Dependants
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ClaimsDetailsRepository:CrudRepository<ClaimsDetails,String>{
@Query("SELECT * FROM CLAIMSDETAILS")

    fun findAllClaims():List<ClaimsDetails>
    fun findClaimsByBeneficiaryid(beneficiaryid : Int) : List<ClaimsDetails>
    fun findClaimsByBenefitid(benefitid : Int): List<ClaimsDetails>

}