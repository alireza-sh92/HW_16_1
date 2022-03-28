package com.example.hw_16_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_16_1.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myViewPager = binding.viewPager
        val myFragmentAdapter = MyFragmentAdapter(this)
        myViewPager.adapter = myFragmentAdapter
        val myTabLayout = binding.tabLayout

        TabLayoutMediator(myTabLayout,myViewPager) {tab, position ->
            when(position) {
                0 -> {tab.text = "To- Do"}
                1 -> {tab.text = "Doing"}
                2 -> {tab.text = "Done"}
            }
        }.attach()
    }
}