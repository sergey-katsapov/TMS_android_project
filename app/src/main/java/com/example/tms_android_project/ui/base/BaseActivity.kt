package com.example.tms_android_project.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.ActivityBaseBinding
import com.example.tms_android_project.databinding.ActivityMainBinding
import com.example.tms_android_project.ui.fragments.FirstFragment
import com.example.tms_android_project.ui.fragments.SecondFragment


class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.navigateTo.setOnClickListener {
            replaceFragment(fragment = FirstFragment())
        }

        binding.navigateBack.setOnClickListener {
            replaceFragment(fragment = SecondFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }
}