package com.example.foodmarketkotlinpractice.ui.auth

import androidx.lifecycle.ViewModel
import com.example.foodmarketkotlinpractice.data.AuthRepository

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    fun registUser(
        name: String,
        email: String,
        password: String,
        password_confirmation: String,
        address: String,
        city: String,
        houseNumber: String,
        phoneNumber: String
    ) = authRepository.registerUser(
        name,
        email,
        password,
        password_confirmation,
        address,
        city,
        houseNumber,
        phoneNumber
    )
}