package com.dnsoftindia.friend.services

import com.dnsoftindia.friend.model.Friend
import com.dnsoftindia.friend.service.FriendService
import org.assertj.core.api.Assertions
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ServiceTests {

    @Autowired
    lateinit var friendService: FriendService

    @Test
    fun testCreateReadDelete() {
        val friend = Friend(firstName = "Rocket", lastName = "Singh")
        friendService.save(friend)

        val friends = friendService.findAll()
        Assertions.assertThat(friends).last().hasFieldOrPropertyWithValue("firstName", "Rocket")

        friendService.deleteAll()
        Assertions.assertThat(friendService.findAll()).isEmpty()
    }

}