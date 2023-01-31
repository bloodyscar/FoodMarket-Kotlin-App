package com.example.foodmarketkotlinpractice.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.foodmarketkotlinpractice.data.remote.response.RegisterUserResponse
import com.example.foodmarketkotlinpractice.data.remote.retrofit.ApiService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthRepository private constructor(
    private val apiService: ApiService
) {

    private val result = MediatorLiveData<Result<RegisterUserResponse>>()

    fun registerUser(
        name: String,
        email: String,
        password: String,
        password_confirmation: String,
        address: String,
        city: String,
        houseNumber: String,
        phoneNumber: String,
    ): LiveData<Result<RegisterUserResponse>> {
        result.value = Result.Loading
        val client = apiService.postRegisterUser(
            name,
            email,
            password,
            password_confirmation,
            address,
            city,
            houseNumber,
            phoneNumber
        )



        client.enqueue(object : Callback<RegisterUserResponse> {
            override fun onResponse(
                call: Call<RegisterUserResponse>,
                response: Response<RegisterUserResponse>
            ) {

                if(response.isSuccessful){
                    val responseBody = response.body()
                    if(responseBody != null){
                        result.value = Result.Success(responseBody)
                    }
                    Log.d("registerUser", responseBody.toString())
                } else {
                    result.value = Result.Error(response.message())



                }
            }

            override fun onFailure(call: Call<RegisterUserResponse>, t: Throwable) {
                Log.d("registerUser", t.message.toString())
                result.value = Result.Error(t.message.toString())
            }

        })
        return result
    }

    companion object {
        @Volatile
        private var instance: AuthRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): AuthRepository =
            instance ?: synchronized(this) {
                instance ?: AuthRepository(apiService)
            }.also { instance = it }
    }
}