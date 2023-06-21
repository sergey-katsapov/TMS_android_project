package com.example.tms_android_project.ui.presentation.fragments

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.databinding.NewsFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.custom.InternetChangeReceiver
import com.example.tms_android_project.ui.presentation.custom.ModeChangeReceiver
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding

    private val viewModel: NewsViewModel by viewModels()
    private var isTimerRunning: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        airplaneModeReceiver()
        internetModeReceiver()

        startTimer()
        observePosts()
    }

    private fun airplaneModeReceiver(){
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also { intentFilter ->
            activity?.registerReceiver(ModeChangeReceiver(), intentFilter)
        }
    }

    private fun internetModeReceiver(){
        activity?.registerReceiver(InternetChangeReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    private fun observePosts() {
        viewModel.postList.observe(viewLifecycleOwner) { posts ->
            initRecycler(posts)
        }
    }

    private fun testUiTread(){
        val runnable = Runnable {

            val hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val minutes = Calendar.getInstance().get(Calendar.MINUTE)
            val seconds = Calendar.getInstance().get(Calendar.SECOND)

            val time = "$hours:$minutes:$seconds"
            binding.testTextView.text = time
        }

        val thread = Thread(runnable)
        thread.start()
    }

     private fun startTimer() {
         object : CountDownTimer(SECONDS, ONE_SECOND) {
             override fun onTick(millisUntilFinished: Long) {
                 binding.testTextView.text = (TIMER + millisUntilFinished / 1000)
             }

             override fun onFinish() {
                 binding.testTextView.text = FINISH
             }
         }.start()
     }

    private fun initRecycler(posts: List<DomainPost>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(
                items = posts,
                onItemClickEvent = {
                    testUiTread()
                   // findNavController().navigate(R.id.action_NewsFragment_to_NewsInfoFragment)
                }
            )
        }
    }

    companion object {
        private const val FINISH = "finish"
        private const val TIMER = "timer:"
        private const val SECONDS = 30000L
        private const val ONE_SECOND = 1000L
    }
}