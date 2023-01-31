package com.example.foodmarketkotlinpractice.ui.auth.signin

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodmarketkotlinpractice.MainActivity
import com.example.foodmarketkotlinpractice.databinding.FragmentSigninBinding
import com.example.foodmarketkotlinpractice.ui.auth.AuthActivity


class SigninFragment : Fragment() {
    private lateinit var binding: FragmentSigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnCreateAccount.setOnClickListener {
            val signup = Intent(activity, AuthActivity::class.java)
            signup.putExtra("page_request", 2)
            startActivity(signup)

        }

        binding.btnSignin.setOnClickListener {
            val home = Intent(activity, MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }

    }




}