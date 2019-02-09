package com.dnsoftindia.friend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(basePackages = ["com.dnsoftindia.friend"])
class FriendApplication

fun main(args: Array<String>) {
	runApplication<FriendApplication>(*args)
}

