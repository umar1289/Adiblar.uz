package com.test.adiblaruz.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.adiblaruz.JahonAdabiyotiFragment
import com.test.adiblaruz.MumtozAdabiyotFragment
import com.test.adiblaruz.OzbekAdabiyotiFragment

class ViewPagerAdapter2(fragmentManager1: FragmentManager?): FragmentPagerAdapter(fragmentManager1!!) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> MumtozAdabiyotFragment()
            1-> OzbekAdabiyotiFragment()
            2-> JahonAdabiyotiFragment()
            else -> MumtozAdabiyotFragment()
        }
    }

}