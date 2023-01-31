package com.example.foodmarketkotlinpractice.ui.auth.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.Result
import com.example.foodmarketkotlinpractice.databinding.FragmentSignupAddressBinding
import com.example.foodmarketkotlinpractice.ui.ViewModelFactory
import com.example.foodmarketkotlinpractice.ui.auth.AuthActivity
import com.example.foodmarketkotlinpractice.ui.auth.AuthViewModel

class SignupAddressFragment : Fragment() {
    private lateinit var binding: FragmentSignupAddressBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupAddressBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(requireActivity())
        val viewModel: AuthViewModel by viewModels {
            factory
        }
        binding?.progressBar?.visibility = View.GONE




        binding.btnSignupNow.setOnClickListener {
            val name = SignupAddressFragmentArgs.fromBundle(arguments as Bundle).name
            val password = SignupAddressFragmentArgs.fromBundle(arguments as Bundle).password
            val email = SignupAddressFragmentArgs.fromBundle(arguments as Bundle).email

            val phone = binding.edtPhone.text
            val address = binding.edtAddress.text
            val houseNo = binding.edtHouseNo.text
            val city = binding.edtCity.text


            val mBundle = Bundle()



            viewModel.registUser(
                name,
                email,
                password,
                password,
                address.toString(),
                city.toString(),
                houseNo.toString(),
                phone.toString()
            ).observe(viewLifecycleOwner) { result ->
                Log.d("asdsa", result.toString())
                if(result != null){
                    when(result){
                        is Result.Loading -> {
                            binding?.progressBar?.visibility = View.VISIBLE
                        }
                        is Result.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            toast("Terjadi Kesalahan " + result.error)
                        }
                        is Result.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            toast("Registrasi Berhasil")
                            view.findNavController().navigate(R.id.action_signUpNow)
                            (activity as AuthActivity).hideToolbar()
                        }
                    }
                }
            }




        }
    }

    private fun toast(msg : String){
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
    }


}