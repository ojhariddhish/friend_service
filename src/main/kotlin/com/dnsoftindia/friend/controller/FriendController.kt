package com.dnsoftindia.friend.controller

import com.dnsoftindia.friend.model.Friend
import com.dnsoftindia.friend.service.FriendService
import com.dnsoftindia.friend.util.ErrorMessage
import com.dnsoftindia.friend.util.FieldErrorMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors
import javax.validation.Valid
import javax.validation.ValidationException

@RestController
class FriendController {

    @Autowired
    lateinit var friendService: FriendService

    @PostMapping("/friend")
    fun create(@Valid @RequestBody friend: Friend): Friend {
        return friendService.save(friend)
    }

    @GetMapping("/friend")
    fun read(): Iterable<Friend> {
        return friendService.findAll()
    }

    @PutMapping("/friend")
    fun update(@RequestBody friend: Friend): ResponseEntity<Friend> {
        if (friendService.findById(friend.id).isPresent) {
            return ResponseEntity(friendService.save(friend), HttpStatus.OK)
        }
        else {
            return ResponseEntity(friend, HttpStatus.BAD_REQUEST)
        }
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun exceptionHandler(e: MethodArgumentNotValidException): List<FieldErrorMessage> {
        val fieldErrors = e.bindingResult.fieldErrors
        return fieldErrors.stream().map {
            FieldErrorMessage(it.field, it.defaultMessage)
        }.collect(Collectors.toList())
    }

}