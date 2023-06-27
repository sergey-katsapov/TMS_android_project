package com.example.tms_android_project.ui.presentation.fragments

import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ServiceCompat.stopForeground
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.tms_android_project.databinding.ServiceFragmentBinding
import com.example.tms_android_project.ui.presentation.custom.MusicService
import com.example.tms_android_project.ui.presentation.custom.NotificationWorkManager
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
        val request = OneTimeWorkRequestBuilder<NotificationWorkManager>().build()


        with(binding) {
            activity?.let { context ->
                startService.setOnClickListener {
                    WorkManager.getInstance(context).enqueue(request)
                }
//                startService()
//
//                activity?.startService(
//                    Intent(activity, MusicService::class.java)
//                )

                endService.setOnClickListener {
                    //WorkManager.getInstance(context).cancelAllWork()
                    //WorkManager.getInstance(context).cancelWorkById(request.id)

                   // stopForeground(NotificationWorkManager())
                    //stopService()

//                activity?.stopService(
//                    Intent(activity, MusicService::class.java)
//                )
                }
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