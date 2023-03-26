package com.wellhealth.healthy.dataclasses

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("claimscategories")
data class ClaimsCategories(
    @Id val id:Int,
    val beneficiaryid:Int,
    val policyid:Int,
    val effectivedate:Date,
    val invoicetype:String,
    val invoicebenefit:String,
    val settledamount:Double
)
data class Categories(
    val invoicetype:String,
    val settledamount:Double

    )
data class InvoiceBenefits(

    val beneficiaryid:Int,
    val policyid:Int,
    val effectivedate:Date,
    val invoicebenefit:String,
    val invoicetype: List<Categories>



    )