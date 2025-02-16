package com.nextyou.be.service.user

import com.nextyou.be.common.NotFoundException
import com.nextyou.be.dto.user.request.UserInfoUpdateRequest
import com.nextyou.be.dto.user.request.UserRegisterRequest
import com.nextyou.be.dto.user.response.UserResponse
import com.nextyou.be.entity.UserEntity
import com.nextyou.be.repository.user.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun save(request: UserRegisterRequest): Mono<UserResponse> {
        val response = userRepository.save(request.toEntity())

        return response.map { it.toResponseDto() }
    }

    fun findUser(userId: String): Mono<UserResponse> {
        return findUserById(userId).map { it.toResponseDto() }
    }

    fun modifyUserInfo(userId: String, request: UserInfoUpdateRequest): Mono<UserResponse> {
        return findUserById(userId)
            .flatMap {
                userRepository.save(
                    it.apply {
                        name = request.name
                        phoneNumber = request.phoneNumber
                        birthDate = request.birthDate
                        gender = request.gender
                        profileImageUrl = request.profileImageUrl
                    }
                )
            }
            .map { it.toResponseDto() }
    }

    fun deleteUser(userId: String): Mono<Void> {
        return findUserById(userId)
            .flatMap(userRepository::delete)
    }

    private fun findUserById(userId: String): Mono<UserEntity> {
        return userRepository.findById(userId)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("존재하지 않는 사용자입니다.")
                )
            )
    }
}