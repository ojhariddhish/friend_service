package com.dnsoftindia.friend.service

import com.dnsoftindia.friend.model.Friend
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface FriendService : CrudRepository<Friend, Int>{

    fun findByFirstNameAndLastName(firstName: String, lastName: String): Iterable<Friend>

    fun findByFirstName(firstName: String): Iterable<Friend>

    fun findByLastName(lastName: String): Iterable<Friend>
}