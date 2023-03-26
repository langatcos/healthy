package com.wellhealth.healthy.dataclasses

import org.springframework.data.annotation.Id
import java.util.*

data class claimsCategories(
    @Id val id:Int,
    val beneficiaryid:Int,
    val policyid:Int,
    val effectivedate:Date,
    val invoicetype:String,
    val invoicebenefit:String,
    val settledamount:Double
)