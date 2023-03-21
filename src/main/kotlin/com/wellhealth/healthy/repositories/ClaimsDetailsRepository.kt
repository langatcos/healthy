package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.services.ClaimsDetails
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ClaimsDetailsRepository: CrudRepository<ClaimsDetails,kotlin.String>{
    @Query("SELECT assessmentid ,beneficiaryid,\n" +
            "       policyid,\n" +
            "       effectivedate1 AS effectivedate,\n" +
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
    fun getAllclaimsdetailsbyId(beneficiaryid:Int) : List<ClaimsDetails>
}