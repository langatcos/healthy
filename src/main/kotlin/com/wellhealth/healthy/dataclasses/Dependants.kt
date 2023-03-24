package com.wellhealth.healthy.dataclasses

import org.springframework.data.annotation.Id
import java.util.*

data class Dependants (
    @Id val entityid:Int,
    val parentid:Int,
    val firstname:String,
    val Surname:String,
    val dob:String,
    val joindate:Date,
    val relationship:String
)