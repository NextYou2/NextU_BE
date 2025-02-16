package com.nextyou.be.controller.user

import com.nextyou.be.dto.user.request.UserInfoUpdateRequest
import com.nextyou.be.dto.user.request.UserRegisterRequest
import com.nextyou.be.dto.user.response.UserResponse
import com.nextyou.be.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(
        @RequestBody request: UserRegisterRequest,
    ): Mono<ResponseEntity<UserResponse>> {
        return userService.save(request)
            .map { ResponseEntity.ok(it) }
    }

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: String,
    ): Mono<ResponseEntity<UserResponse>> {
       return userService.findUser(userId)
           .map { ResponseEntity.ok(it) }
    }

    @PutMapping("/{userId}")
    fun updateUserInfo(
        @PathVariable userId: String,
        @RequestBody request: UserInfoUpdateRequest,
    ): Mono<ResponseEntity<UserResponse>> {
        return userService.modifyUserInfo(userId, request)
            .map { ResponseEntity.ok(it) }
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(
        @PathVariable userId: String,
    ): Mono<ResponseEntity<Void>> {
        return userService.deleteUser(userId)
            .then(Mono.fromCallable { ResponseEntity.noContent().build() })
    }
}