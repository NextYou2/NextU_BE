package com.nextyou.be.entity

import com.nextyou.be.code.GenderType
import com.nextyou.be.dto.user.response.UserResponse
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDate

@Document(collection = "user")
data class UserEntity(
    @Field("email")
    val email: String,

    @Field("name")
    var name: String,

    @Field("phone_number")
    var phoneNumber: String,

    @Field("birth_date")
    var birthDate: LocalDate,

    @Field("gender")
    var gender: GenderType,

    @Field("profile_image_url")
    var profileImageUrl: String,

    @Field("additional_info")
    var additionalInfo: AdditionalInfo? = null

) : BaseDocumentEntity() {
    fun toResponseDto(): UserResponse {
        return UserResponse(
            id = id.toString(),
            email = email,
            name = name,
            phoneNumber = phoneNumber,
            birthDate = birthDate,
            gender = gender,
            profileImageUrl = profileImageUrl,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
    }
}

data class AdditionalInfo(
    @Field("hobby")
    val hobby: List<String>? = null,
)