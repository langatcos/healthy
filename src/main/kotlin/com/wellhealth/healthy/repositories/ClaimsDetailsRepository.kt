package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.ClaimsDetails
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ClaimsDetailsRepository: CrudRepository<ClaimsDetails,String>{
    @Query("SELECT random() as id,\n" +
            "       assessmentid ," +
            "       beneficiaryid,\n" +
            "       policyid,\n" +
            "       effectivedate,\n" +
            "       invoicetypedesc,\n" +
            "       invoicereference,\n" +
            "       treatmentdate,\n" +
            "       beneficiaryname,\n" +
            "       firstdiagnosis,\n" +
            "       invoicebenefit,\n" +
            "       invoicelinesubbenefit,\n" +
            "       invoicelinedetails,\n" +
            "       invoiceentityname AS provider,\n" +
            "       invoicestatus,\n" +
            "       settledamount\n" +
            "  FROM CLAIMSDETAILS")
    fun getAllBybeneficiarid(beneficiaryid : Int) : List<ClaimsDetails>
}