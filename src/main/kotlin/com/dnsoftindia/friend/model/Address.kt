package com.dnsoftindia.friend.model

import javax.persistence.*

@Entity
data class Address(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        val street: String,
        val city: String) {
}