package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tms_android_project.databinding.TestAnimationFragmentBinding


class TestAnimationFragment : Fragment() {

    private lateinit var binding: TestAnimationFragmentBinding
    private var maxCoinCount: Int = 9

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TestAnimationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonsInitialization()

        binding.apply {
            koinView.setRollingEndListener {
                startAnimation.isEnabled = true
            }
        }

//        val fadeIn: Animation = AlphaAnimation(0f, 1f)
//        fadeIn.duration = 3000
//
//        val fadeOut: Animation = AlphaAnimation(1f, 0f)
//        fadeOut.duration = 3000
//
//        val animation = AnimationSet(true)
//
//        animation.addAnimation(fadeIn)
//        animation.addAnimation(fadeOut)

       // binding.icTest.startAnimation(animation)
    }

    private fun buttonsInitialization() {
        binding.apply {
            startAnimation.setOnClickListener {
                startAnimation.isEnabled = false

                koinView.post {
                    if (maxCoinCount >= 0) {
                        koinView.addCircle(number = maxCoinCount)
                        maxCoinCount--
                    }
                }
            }

            clearAnimation.setOnClickListener {
                koinView.clearCircles()
                maxCoinCount = 9
            }
        }
    }
}