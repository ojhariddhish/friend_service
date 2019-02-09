package com.dnsoftindia.friend.controller

import com.dnsoftindia.friend.model.Friend
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.validation.ValidationException

@RunWith(SpringRunner::class)
@SpringBootTest
class IntegrationTests {

    @Autowired
    lateinit var friendController: FriendController

    @Test
    fun testCreateReadDelete() {
        val friend = Friend(firstName = "Ramkhilavan", lastName = "Pandey")
        val friendResult = friendController.create(friend)
        System.out.println(friendResult.toString())

        val friends = friendController.read()
        Assertions.assertThat(friends).last().hasFieldOrPropertyWithValue("firstName", "Ramkhilavan")

        friendController.delete(friendResult.id)
        Assertions.assertThat(friendController.read()).doesNotContain(friendResult)
    }

    @Test(expected = ValidationException::class)
    fun errorHandlingValidationExceptionThrown() {
        friendController.somethingWrong()
    }

}