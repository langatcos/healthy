package com.wellhealth.healthy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJdbcRepositories
class HealthyApplication

fun main(args: Array<String>) {
	runApplication<HealthyApplication>(*args)
}
