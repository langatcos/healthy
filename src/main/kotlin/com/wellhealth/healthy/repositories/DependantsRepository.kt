package com.wellhealth.healthy.repositories

import com.wellhealth.healthy.dataclasses.Dependants
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

interface DependantsRepository:CrudRepository<Dependants,String>  {
    @Query("select * from dependants")
   // fun getAllDependants() : List<Dependants>
    fun findAllpolicybeneficiaryBypolicyid(policyid:Int, effectivedate: String) : List<Dependants>

   fun findAllpolicybeneficiaryByparentid(parentid:Int) : List<Dependants>
   fun findAllByentityid(entityid :Int) : List<Dependants>

}