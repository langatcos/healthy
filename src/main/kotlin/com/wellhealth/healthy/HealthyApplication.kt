package com.wellhealth.healthy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@EnableJdbcRepositories
@SpringBootApplication
class HealthyApplication

fun main(args: Array<String>) {
	runApplication<HealthyApplication>(*args)
}
