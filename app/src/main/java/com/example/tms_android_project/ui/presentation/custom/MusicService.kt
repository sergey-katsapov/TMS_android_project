package com.example.tms_android_project.ui.presentation.custom

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.tms_android_project.ui.presentation.fragments.ServiceFragment


class MusicService : Service() {

    val CHANNEL_ID = "ForegroundServiceChannel"

    private lateinit var player : MediaPlayer

//    override fun onStartCommand(init : Intent, flag : Int, startId: Int):Int{
//        player = MediaPlayer.create(this@MusicService, Settings.System.DEFAULT_RINGTONE_URI)
//        player.setLooping(true)
//        player.start()
//        return  START_STICKY
//    }

    override fun onDestroy() {
        super.onDestroy()
   //     player.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(this, ServiceFragment::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(input)
          //  .setSmallIcon(R.drawable.ic_stat_name)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        //do heavy work on a background thread
        //stopSelf();
        return START_NOT_STICKY
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }
}