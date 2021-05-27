package com.dicoding.ratingapp.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.ratingapp.home.populer.HomePopulerFragment
import com.dicoding.ratingapp.home.rekomendasi.HomeRekomendasiFragment

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "populer"
            1 -> "rekomendasi"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position){
            0 -> {
                fragment = HomePopulerFragment()
                return fragment
            }
            1 -> {
                fragment = HomeRekomendasiFragment()
                return fragment
            }
            else -> {
                fragment = HomePopulerFragment()
                return fragment
            }
        }
    }
}