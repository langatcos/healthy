package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.Users
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<Users,String> {
    @Query("select * from users")
    fun getAllUsers():List<Users>
    fun findAllByusername (username: String):List<Users>
    fun findAllByentityid (entityid: Int):List<Users>
    fun findUserByuserid(userid: Int): Users?
    fun getUserByuserid(userid: Int): List<Users>


}