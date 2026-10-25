package com.example.edushare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.edushare.Bookmark.BookmarkFragment
import com.example.edushare.Home.HomeFragment
import com.example.edushare.Profile.ProfileFragment
import com.example.edushare.Search.SearchFragment
import com.example.edushare.Upload.UploadFragment
import com.example.edushare.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Halaman pertama yang dibuka adalah Home
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Navigasi Bottom Navigation
        binding.bottomNavView.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.nav_search -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.nav_upload -> {
                    replaceFragment(UploadFragment())
                    true
                }

                R.id.nav_bookmark -> {
                    replaceFragment(BookmarkFragment())
                    true
                }

                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}