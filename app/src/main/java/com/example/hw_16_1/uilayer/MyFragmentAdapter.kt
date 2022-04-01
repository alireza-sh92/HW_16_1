package com.example.hw_16_1.uilayer

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentAdapter(fragmentManager: AppCompatActivity) :
    FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ToDoFragment()
            }
            1 -> {
                DoingFragment()
            }
            2 -> {
                DoneFragment()
            }
            else -> ToDoFragment()
        }
    }
}