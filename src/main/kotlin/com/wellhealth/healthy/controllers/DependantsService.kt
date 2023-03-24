package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Dependants
import com.wellhealth.healthy.dataclasses.Users
import com.wellhealth.healthy.repositories.DependantsRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class DependantsService (val dependantsRepository: DependantsRepository) {
    @GetMapping("/getDependantsbyParentID/{parentid}")
    @ApiOperation(value = "Get Dependants by Parent ID", notes = "Get Dependants by Parent ID")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
     fun getDependants(@PathVariable parentid:Int):ResponseEntity<List<Dependants>> {
        val depArray = dependantsRepository.findAllpolicybeneficiaryByparentid(parentid)
        return if(depArray !=null){
            ResponseEntity.ok(depArray)
        }else{
            ResponseEntity.notFound().build()
        }

    }
    @GetMapping("/getdependantsdetails/{entityid}")
    @ApiOperation(value = "Get dependants details by ID", notes = "Get details by iD (Entityid")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getDependantsbyEntityid(@PathVariable entityid:Int):ResponseEntity<List<Dependants>> {

        val depArray = dependantsRepository.findAllByentityid(entityid)

        return if (depArray != null) {
            ResponseEntity.ok(depArray)
        } else {
            ResponseEntity.notFound().build()

        }
    }
    @GetMapping("/getDependantsbyPolicyid/{policyid}/{effectivedate}")
    @ApiOperation(value = "Get all dependants by policyid and effectivedate", notes = "Get all The dependants by policyid and effectivedate ")
    @CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
    fun getDependantsbypolicyid(@PathVariable policyid:Int, @PathVariable effectivedate:String):ResponseEntity<List<Dependants>> {

        val depArray = dependantsRepository.findAllpolicybeneficiaryBypolicyid(policyid, effectivedate)

        return if(depArray !=null) {
            ResponseEntity.ok(depArray)
        }
        else{
            ResponseEntity.notFound().build()

        }
    }
}