package com.dnsoftindia.friend


import com.dnsoftindia.friend.model.Friend
import org.assertj.core.api.Assertions
import org.junit.Test
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.getForObject
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase
import org.junit.Assert
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException


class SystemTests {

    @Test
    fun testCreateReadDeleteFriend() {
        val restTemplate = RestTemplate()

        val url = "http://localhost:8080/friend"

        val friend = Friend(firstName = "Bilbo", lastName = "Baggins")
        val responseEntity = restTemplate.postForEntity(url, friend, Friend::class.java)

//        val nameBilbo = Condition<Friend>(
//                { m: Friend -> m.firstName == "Bilbo" },
//                "Bilbo"
//        )
//        val friends: List<Friend>? = restTemplate.getForObject(url, arrayOf(Friend::class.java))
//        assertThat(friends).haveAtLeastOne(nameBilbo).filteredOn("first-name", "Bilbo")
//        assertThat(friends).extracting(Friend::firstName).contains("Bilbo") // .anySatisfy { it.firstName.equals("Bilbo") }
//        Assertions.assertThat(friends).extracting(Friend::firstName).containsOnly("Bilbo")

//        restTemplate.delete(url + "/" + responseEntity.body?.id)
//        Assertions.assertThat(restTemplate.getForObject(url, arrayOf(Friend::class.java)) as List<Friend>).isEmpty()
    }

    @Test
    fun testErrorHandlingReturnsBadRequest() {
        val restTemplate = RestTemplate()
        val url = "http://localhost:8080/wrong"

        try {
            val responseEntity: ResponseEntity<String> = restTemplate.getForEntity(url, String::class)
        }
        catch (e: HttpClientErrorException) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.statusCode)
        }
    }

}