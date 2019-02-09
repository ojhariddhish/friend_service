package com.dnsoftindia.friend

import com.dnsoftindia.friend.controller.FriendController
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FriendApplicationTests {

	@Autowired
	lateinit var friendController: FriendController

	@Test
	fun contextLoads() {
		Assert.assertNotNull(friendController)

	}

}

