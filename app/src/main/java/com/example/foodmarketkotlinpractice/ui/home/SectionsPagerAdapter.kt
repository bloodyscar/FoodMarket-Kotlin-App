package com.example.foodmarketkotlinpractice.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodmarketkotlinpractice.ui.home.newtaste.NewTasteFragment

class SectionsPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = NewTasteFragment()
        var bundle = Bundle()

        if (position == 0) {
            bundle.putString(HomeFragment.ARG_TAB, HomeFragment.TAB_NEW_TASTE)
        } else if ( position == 1) {
            bundle.putString(HomeFragment.ARG_TAB, HomeFragment.TAB_POPULAR)
        } else {
            bundle.putString(HomeFragment.ARG_TAB, HomeFragment.TAB_RECOMMENDED)

        }

        fragment.arguments = bundle
        return fragment
    }
}