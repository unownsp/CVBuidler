package com.saugat.cvbuilderapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.saugat.cvbuilderapplication.R
import com.saugat.cvbuilderapplication.adapter.ViewPagerAdapter
import com.saugat.cvbuilderapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        //initializing tab layout
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val tabName: String = when (position) {
                0 -> getString(R.string.home)
                1 -> getString(R.string.about_me)
                2 -> getString(R.string.work)
                3 -> getString(R.string.contact)
                else -> getString(R.string.home)
            }
            tab.text = tabName

        }.attach()

    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}