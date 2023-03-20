package com.wellhealth.healthy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HealthyApplication

fun main(args: Array<String>) {
	runApplication<HealthyApplication>(*args)
}
