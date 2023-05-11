package com.example.tms_android_project.ui.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_android_project.databinding.ActivityBaseBinding


class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.navigateTo.setOnClickListener {
//            replaceFragment(fragment = FirstFragment())
//        }
//
//        binding.navigateBack.setOnClickListener {
//            replaceFragment(fragment = SecondFragment())
//        }
    }

//    private fun replaceFragment(fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        fragmentManager
//            .beginTransaction()
//            .replace(R.id.main_fragment_container, fragment)
//            .commit()
//    }
}