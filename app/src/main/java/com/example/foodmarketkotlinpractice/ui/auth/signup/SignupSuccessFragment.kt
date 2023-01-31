package com.example.foodmarketkotlinpractice.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.FragmentSignupSuccessBinding
import com.example.foodmarketkotlinpractice.ui.auth.AuthActivity

class SignupSuccessFragment : Fragment() {
    private lateinit var binding : FragmentSignupSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupSuccessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}