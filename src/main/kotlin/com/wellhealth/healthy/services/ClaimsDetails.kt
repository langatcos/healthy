package com.wellhealth.healthy.services

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("claimsdetails")
class ClaimsDetails(
    @Id val id:String,
    val assessmentid:Int,
    val beneficiaryid:Int,
    val policyid:Int,
    val effectivedate:String,
    val invoicetypedesc:String,
    val invoicereference:String,
    val treatmentdate:String,
    val beneficiaryname:String,
    val firstdiagnosis:String,
    val invoicebenefit:String,
    val invoicelinesubbenefit:String,
    val  invoicelinedetails:String,
    val provider:String,
    val invoicestatus:String,
    val settledamount:Double
)