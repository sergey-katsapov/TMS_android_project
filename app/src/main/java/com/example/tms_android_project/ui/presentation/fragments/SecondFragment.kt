package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tms_android_project.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(inflater, container, false)

        val bundle = this.arguments
        Log.d("TEST_ANDROID", "${bundle?.getInt("TestArg")}")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnSecondClick.setOnClickListener {
            Toast.makeText(context, "This is second fragment", Toast.LENGTH_SHORT).show()
        }
    }
}