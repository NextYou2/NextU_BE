package com.nextyou.be.dto.user.request

import com.nextyou.be.code.GenderType
import com.nextyou.be.entity.UserEntity
import java.time.LocalDate

data class UserRegisterRequest(
    val email: String,
    val name: String,
    val phoneNumber: String,
    val birthDate: LocalDate,
    val gender: GenderType,
    val profileImageUrl: String,
    val additionalInfo: AdditionalInfoDto? = null
) {
    fun toEntity(): UserEntity {
        return UserEntity(
            email = email,
            name = name,
            phoneNumber = phoneNumber,
            birthDate = birthDate,
            gender = gender,
            profileImageUrl = profileImageUrl,
        )
    }
}

data class AdditionalInfoDto(
    val hobby: List<String>? = null,
)