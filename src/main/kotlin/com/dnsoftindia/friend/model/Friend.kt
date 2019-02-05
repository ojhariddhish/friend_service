package com.dnsoftindia.friend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Friend(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int = -1,
                  @JsonProperty("first-name") @field:NotBlank val firstName: String = "",
                  @JsonProperty("last-name") val lastName: String = "",
                  val age: Int = -1,
                  @JsonIgnore val married: Boolean = false,
                  @OneToMany(cascade = arrayOf(CascadeType.ALL)) val addresses: List<Address> = emptyList()) {
}