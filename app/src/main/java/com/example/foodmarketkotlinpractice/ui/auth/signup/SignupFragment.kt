package com.example.foodmarketkotlinpractice.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.foodmarketkotlinpractice.databinding.FragmentSignupBinding
import com.example.foodmarketkotlinpractice.ui.auth.AuthActivity

class SignupFragment : Fragment() {
    private lateinit var binding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btnContinue.setOnClickListener {
            val mBundle = Bundle()
            val name = binding.edtFullname.text
            val password = binding.edtPassword.text
            val email = binding.edtEmail.text

            val actionContinue = SignupFragmentDirections.actionContinue(
                name.toString(),
                password.toString(),
                email.toString()
            )

            Navigation.findNavController(it).navigate(actionContinue)
            (activity as AuthActivity).toolbarSignupAddress()

        }
    }


}