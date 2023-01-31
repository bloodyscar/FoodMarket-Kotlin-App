package com.example.foodmarketkotlinpractice.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {
    private lateinit var paymentBinding: FragmentPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as DetailActivity).toolbarPayment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paymentBinding = FragmentPaymentBinding.inflate(inflater, container, false)
        return paymentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCheckoutNow = paymentBinding.btnCheckoutNow

        btnCheckoutNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment_success)
            (activity as DetailActivity).hideToolbar()
        }
    }




}