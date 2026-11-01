package com.example.edushare.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edushare.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        val adapter = TutorialFragmentAdapter(
            this,
            fragmentsList
        )

        binding.tutorialViewPager.adapter = adapter

        binding.dotIndicator.attachTo(binding.tutorialViewPager)
    }
}