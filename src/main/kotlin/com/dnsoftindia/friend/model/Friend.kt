package com.dnsoftindia.friend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Friend(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
                  @JsonProperty("first-name") val firstName: String,
                  @JsonProperty("last-name") val lastName: String,
                  val age: Int,
                  @JsonIgnore val married: Boolean,
                  @Embedded val address: Address) {
}