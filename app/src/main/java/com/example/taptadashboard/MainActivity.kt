package com.example.taptadashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.taptadashboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Keypad())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.keypad -> replaceFragment(Keypad())
                R.id.transactions -> replaceFragment(Transactions())
                R.id.analytics -> replaceFragment(Analytics())
                R.id.products -> replaceFragment(Products())
                R.id.menu -> replaceFragment(Menu())

                else -> {

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}