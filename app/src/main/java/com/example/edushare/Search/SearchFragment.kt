package com.example.edushare.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.edushare.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val tabsAdapter = SearchTabsAdapter(this)

        binding.viewPager.adapter = tabsAdapter

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Catatan"
                1 -> tab.text = "Rangkuman"
                2 -> tab.text = "Latihan Soal"
            }

        }.attach()

        binding.txtJumlah.text = "5 hasil"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
