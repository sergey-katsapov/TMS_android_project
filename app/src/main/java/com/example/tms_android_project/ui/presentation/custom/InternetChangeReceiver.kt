package com.example.tms_android_project.ui.presentation.custom

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

import android.widget.Toast

class InternetChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val connectionState = connectedStateEnabled(context)

        if (connectionState) {
            Toast.makeText(context, CONNECTION_ENABLED, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, CONNECTION_DISABLED, Toast.LENGTH_LONG).show()
        }
    }

    private fun connectedStateEnabled(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    private companion object {
        private const val CONNECTION_ENABLED = "Connected"
        private const val CONNECTION_DISABLED = "Not Connected"
    }
}