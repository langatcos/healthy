package com.wellhealth.healthy.controllers

import com.wellhealth.healthy.dataclasses.Dependants
import com.wellhealth.healthy.repositories.DependantsRepository
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DependantsService (val dependants : DependantsRepository) {
    @GetMapping("/getdependantsbyparentid/{parentid}")
    @ApiOperation(value = "Get Deoendants by parentID", notes = "Get Deoendants by parentID")
    fun getdependantsbyparentId(@PathVariable parentid:Int) :ResponseEntity<List<Dependants>>{
       val dep=dependants.getAllbenByparentid(parentid)
      return if(dep !=null){
             ResponseEntity.ok(dep)
        }
        else{
          ResponseEntity.notFound().build()
        }
    }
}