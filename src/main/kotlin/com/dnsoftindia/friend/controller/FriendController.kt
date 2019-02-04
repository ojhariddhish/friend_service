package com.dnsoftindia.friend.controller

import com.dnsoftindia.friend.model.Friend
import com.dnsoftindia.friend.service.FriendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class FriendController {

    @Autowired
    lateinit var friendService: FriendService

    @PostMapping("/friend")
    fun create(@RequestBody friend: Friend): Friend {
        return friendService.save(friend)
    }

    @GetMapping("/friend")
    fun read(): Iterable<Friend> {
        return friendService.findAll()
    }

    @PutMapping("/friend")
    fun update(@RequestBody friend: Friend): Friend {
        return friendService.save(friend)
    }

    @DeleteMapping("/friend/{id}")
    fun delete(@PathVariable id: Int) {
        friendService.deleteById(id)
    }

    @GetMapping("/friend/{id}")
    fun findById(@PathVariable id: Int): Optional<Friend> {
        return friendService.findById(id)
    }

    @GetMapping("/friend/search")
    fun findByQuery(@RequestParam("first", required = false) firstName: String?,
                    @RequestParam("last", required = false) lastName: String?): Iterable<Friend> {
        if (firstName!=null && lastName!=null) {
            return friendService.findByFirstNameAndLastName(firstName, lastName)
        }
        else if (firstName!=null) {
            return friendService.findByFirstName(firstName)
        }
        else if (lastName!=null) {
            return friendService.findByLastName(lastName)
        }
        else {
            return friendService.findAll()
        }


    }



}