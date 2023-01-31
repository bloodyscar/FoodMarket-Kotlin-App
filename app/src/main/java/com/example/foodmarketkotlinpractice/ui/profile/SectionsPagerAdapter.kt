package com.example.foodmarketkotlinpractice.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = AccountFragment()
        val bundle = Bundle()

        if (position == 0) {
            bundle.putString(ProfileFragment.ARGS_TAB, ProfileFragment.TAB_ACCOUNT)
        } else {
            bundle.putString(ProfileFragment.ARGS_TAB, ProfileFragment.TAB_FM)
        }
        fragment.arguments = bundle
        return fragment
    }
}