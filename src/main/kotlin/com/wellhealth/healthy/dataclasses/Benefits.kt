package com.wellhealth.healthy.dataclasses

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*
@Table("benefits")
data class Benefits (
    @Id val id:Int,
    val policyid:Int,
    val effectivedate:Date,
    val benefitid:Int,
    val benefitname:String,
    val distribution:String,
    val limit:Double
)
data class BenefitCategory(
    val benefitid: Int,
    val benefitname: String,
    val distribution: String,
    val limit: Double
)
data class  BenefitDetails(
    val policyid: Int,
    val effectivedate: Date,
    val benefitCategory: List<BenefitCategory>
)

