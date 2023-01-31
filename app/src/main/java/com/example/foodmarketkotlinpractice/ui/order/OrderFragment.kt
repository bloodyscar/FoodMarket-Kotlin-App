package com.example.foodmarketkotlinpractice.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator


class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object{
        private val TAB_TITLES = intArrayOf(R.string.in_progress, R.string.past_orders)
        val ARG_TAB = "tab_name"
        val TAB_INPROGRESS = "In Progress"
        val TAB_PASTORDER = "Past Orders"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(OrderViewModel::class.java)

        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity())
        val tabsLayout = binding.tabsOrder
        val viewPager2 = binding.vpOrder
        viewPager2.adapter = sectionsPagerAdapter

        TabLayoutMediator(tabsLayout, viewPager2) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        val mActionBarToolbar = view.findViewById<Toolbar>(R.id.toolbar)

        (activity as AppCompatActivity?)!!.setSupportActionBar(mActionBarToolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Your Orders"
        (activity as AppCompatActivity?)!!.supportActionBar?.subtitle = "Wait for the best meal"


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}