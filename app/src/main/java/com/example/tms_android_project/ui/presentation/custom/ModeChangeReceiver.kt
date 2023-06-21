package com.example.tms_android_project.ui.presentation.custom

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ModeChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra(STATE_NAME, RETURNED_DESIRE_TYPE) ?: return

        if (isAirplaneModeEnabled) {
            Toast.makeText(context, AIRPLANE_ENABLED, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, AIRPLANE_DISABLED, Toast.LENGTH_LONG).show()
        }
    }

    private companion object {
        private const val STATE_NAME = "state"
        private const val AIRPLANE_ENABLED = "Airplane Mode Enabled"
        private const val AIRPLANE_DISABLED = "Airplane Mode Disabled"
        private const val RETURNED_DESIRE_TYPE = false
    }
}