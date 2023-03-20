package com.wellhealth.healthy.controllers

import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id
import sun.security.util.Password

@Table("Users")
class Users (
    @Id val entityid:String,
    val firstname:String,
    val surname:String,
    val username:String,
    val password:Password
)