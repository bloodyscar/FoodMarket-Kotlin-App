package com.example.foodmarketkotlinpractice.ui.home.newtaste

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.HomeModel
import com.example.foodmarketkotlinpractice.databinding.FragmentHomeBinding
import com.example.foodmarketkotlinpractice.databinding.FragmentNewTasteBinding
import com.example.foodmarketkotlinpractice.ui.home.HomeAdapter
import com.example.foodmarketkotlinpractice.ui.home.HomeFragment

class NewTasteFragment : Fragment() {
    private var foodList : ArrayList<HomeModel> = ArrayList()
    private lateinit var adapter : HomeNewTasteAdapter
    private var _binding: FragmentNewTasteBinding? = null
    private var tabName : String? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion   object {
        const val ARG_SECTION_NUMBER = "section_number"

    }

    fun initDummyNewTaste(){
        foodList = ArrayList()
        foodList.add(HomeModel("Pizza Hut 1", "", 4f))
        foodList.add(HomeModel("Cherry Healthy 1", "", 4f))
        foodList.add(HomeModel("Bakso 1","", 4f))


    }

    fun initDummyPopular(){
        foodList = ArrayList()
        foodList.add(HomeModel("Seblak 1","", 5f))
        foodList.add(HomeModel("Nasgor 1","", 5f))
        foodList.add(HomeModel("Capcay 1","", 5f))
        foodList.add(HomeModel("Kwetiwaw 1","", 5f))
        foodList.add(HomeModel("Telor 1","", 5f))
        foodList.add(HomeModel("Nasi Uduk 1","", 5f))
        foodList.add(HomeModel("Nasi Kuning 1","", 5f))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewTasteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rvVertical = binding.rvHomeVertical
        rvVertical.setHasFixedSize(true)

         tabName = arguments?.getString(HomeFragment.ARG_TAB)

        if(tabName == HomeFragment.TAB_NEW_TASTE){
            adapter = HomeNewTasteAdapter(foodList)
        } else if (tabName == HomeFragment.TAB_POPULAR){
            adapter = HomeNewTasteAdapter(foodList)
        } else {
            adapter = HomeNewTasteAdapter(foodList)
        }


        rvVertical.layoutManager = LinearLayoutManager(context)
        rvVertical.adapter = adapter








    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDummyNewTaste()

    }


}