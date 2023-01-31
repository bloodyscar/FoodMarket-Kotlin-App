package com.example.foodmarketkotlinpractice.data.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterUserResponse(
    @field:SerializedName("meta")
    val meta: Meta,

    @field:SerializedName("data")
    val data: Data
)

data class Meta(
    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String
)

data class Data(
    @field:SerializedName("access_token")
    val access_token: String,

    @field:SerializedName("token_type")
    val token_type: String,

    @field:SerializedName("user")
    val user: UserModel
)

