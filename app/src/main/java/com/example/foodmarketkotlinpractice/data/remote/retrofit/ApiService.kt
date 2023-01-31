package com.example.foodmarketkotlinpractice.data.remote.retrofit

import com.example.foodmarketkotlinpractice.data.remote.response.RegisterUserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email") email : String,
        @Field("password") password: String
    ) : Call<RegisterUserResponse>

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("register")
    fun postRegisterUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String,
        @Field("address") address: String,
        @Field("city") city: String,
        @Field("houseNumber") houseNumber: String,
        @Field("phoneNumber") phoneNumber: String
    ) : Call<RegisterUserResponse>
}