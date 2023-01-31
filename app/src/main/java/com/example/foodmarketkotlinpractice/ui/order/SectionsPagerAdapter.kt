package com.example.foodmarketkotlinpractice.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = OrderFilledFragment()
        val bundle = Bundle()
        if(position == 0){
            bundle.putString(OrderFragment.ARG_TAB, OrderFragment.TAB_INPROGRESS)
        } else {
            bundle.putString(OrderFragment.ARG_TAB, OrderFragment.TAB_PASTORDER)
        }
        fragment.arguments = bundle
        return fragment
    }
}