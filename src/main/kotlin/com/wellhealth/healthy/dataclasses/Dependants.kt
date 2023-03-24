package com.wellhealth.healthy.dataclasses

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("dependants")
data class Dependants (
    @Id val entityid:Int,
    val parentid:Int,
    val firstname:String,
    val Surname:String,
    val dob:String,
    val relationship:String
)