package com.nextyou.be.repository.user

import com.nextyou.be.entity.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<UserEntity, String> {
}