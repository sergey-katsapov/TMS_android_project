package com.example.tms_android_project.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_android_project.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityBaseBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            setSupportActionBar(it.toolbar)
        }
    }
}