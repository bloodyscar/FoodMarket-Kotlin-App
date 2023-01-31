package com.example.foodmarketkotlinpractice.ui.order

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.OrderModel
import com.example.foodmarketkotlinpractice.databinding.FragmentOrderBinding
import com.example.foodmarketkotlinpractice.databinding.FragmentOrderFilledBinding

class OrderFilledFragment : Fragment() {
    private lateinit var listOrder: ArrayList<OrderModel>
    private lateinit var orderFilledBinding: FragmentOrderFilledBinding
    private var tabName : String? = null
    private lateinit var inProgressAdapter : InProgressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabName = arguments?.getString(OrderFragment.ARG_TAB)
        if(tabName == OrderFragment.TAB_INPROGRESS){
            initInProgressModel()
        } else {
            initPastOrders()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderFilledBinding = FragmentOrderFilledBinding.inflate(inflater, container, false)
        return orderFilledBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Log.d("tabName", tabName.toString())
        val rv = orderFilledBinding.rvOrder
        rv.setHasFixedSize(true)

        inProgressAdapter = InProgressAdapter(listOrder)

        rv.adapter = inProgressAdapter
        rv.layoutManager = LinearLayoutManager(requireActivity())

    }

    fun initInProgressModel() {
        listOrder = ArrayList()
        listOrder.add(OrderModel("Bakso", 1, 10000, poster = ""))
        listOrder.add(OrderModel("Cuanki", 2, 20000, poster = ""))
        listOrder.add(OrderModel("Seblak", 3, 30000, poster = ""))
    }

    fun initPastOrders() {
        listOrder = ArrayList()
        listOrder.add(OrderModel("Cimin", 3, 10000, poster = ""))
        listOrder.add(OrderModel("Indomie", 2, 20000, poster = ""))
        listOrder.add(OrderModel("Pizza", 5, 30000, poster = ""))
    }


}