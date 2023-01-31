package com.example.foodmarketkotlinpractice.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.foodmarketkotlinpractice.R

import com.example.foodmarketkotlinpractice.databinding.FragmentSignupAddressBinding
import com.example.foodmarketkotlinpractice.ui.auth.AuthActivity

class SignupAddressFragment : Fragment() {
    private lateinit var binding : FragmentSignupAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupAddressBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnSignupNow.setOnClickListener {
            view.findNavController().navigate(R.id.action_signUpNow)
            (activity as AuthActivity).hideToolbar()

        }
    }


}