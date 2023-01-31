package com.example.foodmarketkotlinpractice.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.AccountModel
import com.example.foodmarketkotlinpractice.data.entity.HomeModel
import com.example.foodmarketkotlinpractice.ui.home.newtaste.HomeNewTasteAdapter

class AccountFragment : Fragment() {
    private var listData: ArrayList<AccountModel> = ArrayList()
    private lateinit var adapter : AccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rvAccount)
        rv.setHasFixedSize(true)
        val tabName = arguments?.getString(ProfileFragment.ARGS_TAB)

        if(tabName == ProfileFragment.TAB_ACCOUNT){
            initDummy()
            adapter = AccountAdapter(listData)
        } else {
            initDummyFM()
            adapter = AccountAdapter(listData)
        }


        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter


    }

    fun initDummy() {
        listData = ArrayList()
        listData.add(AccountModel("Edit Profile"))
        listData.add(AccountModel("Home Address"))
        listData.add(AccountModel("Security"))
        listData.add(AccountModel("Payments"))

    }

    fun initDummyFM() {
        listData = ArrayList()
        listData.add(AccountModel("Rate App"))
        listData.add(AccountModel("Help Center"))
        listData.add(AccountModel("Privacy & Policy"))
        listData.add(AccountModel("Terms & Conditions"))

    }


}