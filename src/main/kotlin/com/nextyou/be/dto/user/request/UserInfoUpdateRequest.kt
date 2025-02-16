package com.nextyou.be.dto.user.request

import com.nextyou.be.code.GenderType
import java.time.LocalDate

data class UserInfoUpdateRequest(
    val name: String,
    val phoneNumber: String,
    val birthDate: LocalDate,
    val gender: GenderType,
    val profileImageUrl: String,
)
