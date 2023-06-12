package com.example.tms_android_project.ui.presentation.custom

import android.animation.Animator

class AnimatorHelper(
    val onStart: () -> Unit = { },
    val onRepeat: (animator: Animator) -> Unit = { },
    val onEnd: () -> Unit = { },
    val onCancel: (animation: Animator) -> Unit = {}
) : Animator.AnimatorListener {

    override fun onAnimationEnd(animator: Animator) {
        onEnd.invoke()
    }

    override fun onAnimationEnd(animator: Animator, isReverse: Boolean) {
        onAnimationEnd(animator)
    }

    override fun onAnimationRepeat(animation: Animator) {
        onRepeat.invoke(animation)
    }

    override fun onAnimationCancel(animation: Animator) {
        onCancel.invoke(animation)
    }

    override fun onAnimationStart(animation: Animator) {
        onStart.invoke()
    }
}