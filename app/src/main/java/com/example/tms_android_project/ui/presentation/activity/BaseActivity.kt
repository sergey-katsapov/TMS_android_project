package com.example.tms_android_project.ui.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_android_project.databinding.ActivityBaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    //DO-2 создаем переменную, которую позже будем проинициализировать
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //DO-3 вызываем статический метод
        binding = ActivityBaseBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}