package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.Dependants
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
@Table("policybeneficiary")
interface DependantsRepository:CrudRepository<Dependants,String> {
    @Query ("select * from policybeneficiary")
    fun getAllbenbyparentid(parentid:Int):List<Dependants>
}