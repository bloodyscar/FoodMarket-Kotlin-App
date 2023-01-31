package com.example.foodmarketkotlinpractice.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserModel(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("email_verified_at")
    val email_verified_at: String? = null,

    @field:SerializedName("roles")
    val roles: String,

    @field:SerializedName("current_team_id")
    val current_team_id: Int? = null,

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("houseNumber")
    val houseNumber: String,

    @field:SerializedName("phoneNumber")
    val phoneNumber: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("created_at")
    val created_at: Long,

    @field:SerializedName("updated_at")
    val updated_at: Long,

    @field:SerializedName("profile_photo_path")
    val profile_photo_path: String? = null,

    @field:SerializedName("profile_photo_url")
    val profile_photo_url: String? = null


)