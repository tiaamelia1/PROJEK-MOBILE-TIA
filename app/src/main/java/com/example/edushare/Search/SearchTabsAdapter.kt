package com.example.edushare.Search

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchTabsAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCatatanFragment()
            1 -> TabRangkumanFragment()
            2 -> TabLatihanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}
