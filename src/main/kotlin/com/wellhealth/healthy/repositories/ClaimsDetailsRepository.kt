package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.ClaimsDetails
import com.wellhealth.healthy.dataclasses.Dependants
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ClaimsDetailsRepository:CrudRepository<ClaimsDetails,String>{
@Query("SELECT random() as id,* FROM CLAIMSDETAILS where beneficiaryid = :beneficiaryid")

    fun findClaimsbyID(beneficiaryid : Int) : List<ClaimsDetails>
}