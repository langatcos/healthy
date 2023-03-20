package com.wellhealth.healthy.services

import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id

@Table("users")
class Users (
    @Id val entityid:String,
    val firstname:String,
    val surname:String,
    val username:String,
    val userpwd:String
)