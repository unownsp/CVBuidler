package com.saugat.cvbuilderapplication.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.saugat.cvbuilderapplication.fragment.AboutMeFragment
import com.saugat.cvbuilderapplication.fragment.ContactFragment
import com.saugat.cvbuilderapplication.fragment.HomeFragment
import com.saugat.cvbuilderapplication.fragment.WorkFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // fixed item size, we have tab item is 4

    override fun createFragment(position: Int): Fragment {

        //creating fragment object according to position
        val fragment: Fragment = when(position) {
            0 -> HomeFragment.newInstance()

            1 -> AboutMeFragment.newInstance()

            2 -> WorkFragment.newInstance()

            3 -> ContactFragment.newInstance()

            else -> HomeFragment.newInstance()
        }

        return fragment
    }

}