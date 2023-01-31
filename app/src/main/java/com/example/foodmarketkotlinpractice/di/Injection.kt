package com.example.foodmarketkotlinpractice.di

import android.content.Context
import com.example.foodmarketkotlinpractice.data.AuthRepository
import com.example.foodmarketkotlinpractice.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): AuthRepository {
        val apiService = ApiConfig.getApiService()
        return AuthRepository.getInstance(apiService)
    }
}