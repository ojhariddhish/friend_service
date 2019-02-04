package com.dnsoftindia.friend.model

import javax.persistence.Embeddable

@Embeddable
data class Address(val street: String, val city: String) {
}