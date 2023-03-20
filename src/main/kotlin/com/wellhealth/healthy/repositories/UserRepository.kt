package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.services.Users
import org.springframework.data.jpa.repository.Query

interface UserRepository {
    @Query("select * from public.users")
    fun getAllUsers():List<Users>
}