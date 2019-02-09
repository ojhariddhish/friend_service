package com.dnsoftindia.friend.controller

import com.dnsoftindia.friend.model.Friend
import com.dnsoftindia.friend.service.FriendService
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@RunWith(SpringRunner::class)
@WebMvcTest(FriendController::class)
class StandaloneControllerTests {

    @MockBean
    lateinit var friendService: FriendService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testCreateReadDelete() {
        val friend = Friend(firstName = "Barry", lastName = "Allen")
        val friends = Arrays.asList(friend)

        Mockito.`when`(friendService.findAll()).thenReturn(friends)

        mockMvc.perform(get("/friend"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$", Matchers.anything()))
                .andExpect(jsonPath("$[0].firstName", Matchers.`is`("Barry")))
    }

}