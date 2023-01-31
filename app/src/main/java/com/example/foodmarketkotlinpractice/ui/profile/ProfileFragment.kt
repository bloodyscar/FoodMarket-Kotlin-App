package com.example.foodmarketkotlinpractice.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    companion object{
        const val ARGS_TAB = "tab_name"
        const val TAB_ACCOUNT = "Account"
        const val TAB_FM = "FoodMarket"
        private val TAB_TITLES = intArrayOf(R.string.account, R.string.food_market )
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPagerAdapter = SectionsPagerAdapter(requireActivity())
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPagerProfile)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabsProfile)
        viewPager?.adapter = sectionPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}