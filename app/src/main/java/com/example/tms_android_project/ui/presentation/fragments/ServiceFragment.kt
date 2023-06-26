package com.example.tms_android_project.ui.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tms_android_project.databinding.ServiceFragmentBinding
import com.example.tms_android_project.ui.presentation.custom.MusicService
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ServiceFragment : Fragment() {

    private lateinit var binding: ServiceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ServiceFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun initButtons() {
        with(binding) {
            startService.setOnClickListener {
                startService()
//                activity?.startService(
//                    Intent(activity, MusicService::class.java)
//                )
            }
            endService.setOnClickListener {
                stopService()
//                activity?.stopService(
//                    Intent(activity, MusicService::class.java)
//                )
            }
        }
    }

    fun startService() {
        activity?.let {
            val serviceIntent = Intent(activity, MusicService::class.java)
            serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android")
            ContextCompat.startForegroundService(it, serviceIntent)
        }
    }

    fun stopService() {
        activity?.stopService(
                    Intent(activity, MusicService::class.java)
                )
//        activity?.let {
//            val serviceIntent = Intent(activity, MusicService::class.java)
//            stopService(it, serviceIntent)
//        }
    }
}