package com.example.tms_android_project.ui.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_android_project.databinding.ActivityBaseBinding
import dagger.hilt.android.AndroidEntryPoint

//DO-7
@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}