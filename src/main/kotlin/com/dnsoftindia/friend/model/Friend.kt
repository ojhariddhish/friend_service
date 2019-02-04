package com.dnsoftindia.friend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Friend(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
                  val firstName: String,
                  val lastName: String) {
}