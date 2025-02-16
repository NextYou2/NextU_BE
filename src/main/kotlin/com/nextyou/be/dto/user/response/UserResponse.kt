package com.nextyou.be.dto.user.response

import com.nextyou.be.code.GenderType
import com.nextyou.be.dto.user.request.AdditionalInfoDto
import java.time.LocalDate
import java.time.LocalDateTime

data class UserResponse(
    val id: String,
    val email: String,
    val name: String,
    val phoneNumber: String,
    val birthDate: LocalDate,
    val gender: GenderType,
    val profileImageUrl: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val additionalInfo: AdditionalInfoDto? = null
)
