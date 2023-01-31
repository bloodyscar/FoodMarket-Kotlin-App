package com.example.foodmarketkotlinpractice.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.HomeModel
import com.example.foodmarketkotlinpractice.databinding.FragmentHomeBinding
import com.example.foodmarketkotlinpractice.ui.home.newtaste.NewTasteFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var foodList: ArrayList<HomeModel> = ArrayList()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {


        private val TAB_TITLES = intArrayOf(R.string.new_taste, R.string.popular, R.string.recommended )
        const val ARG_TAB = "tab_name"
        const val TAB_NEW_TASTE = "New Taste"
        const val TAB_POPULAR = "Popular"
        const val TAB_RECOMMENDED = "Recommended"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDummy()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rvHorizontal = binding.rvHomeHorizontal
        rvHorizontal.setHasFixedSize(true)



        rvHorizontal.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var adapter = HomeAdapter(foodList, requireActivity())
        rvHorizontal.adapter = adapter


        val sectionPagerAdapter = SectionsPagerAdapter(requireActivity())
        val viewPager = view.findViewById<ViewPager2>(R.id.vp2)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabs)
        viewPager?.adapter = sectionPagerAdapter



        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()





    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initDummy() {
        foodList = ArrayList()
        foodList.add(HomeModel("Pizza Hut", "", 1f))
        foodList.add(HomeModel("Cherry Healthy", "", 4f))
        foodList.add(HomeModel("Bakso", "", 5f))

    }
}