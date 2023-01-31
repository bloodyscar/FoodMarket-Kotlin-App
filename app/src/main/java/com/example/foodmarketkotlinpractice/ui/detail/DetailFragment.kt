package com.example.foodmarketkotlinpractice.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var detailBinding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as DetailActivity).hideToolbar()
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(layoutInflater)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailBinding.btnOderNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment)
        }

    }




}