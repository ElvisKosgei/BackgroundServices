package com.elvis.backgroundservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class BackupService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        Toast.makeText(applicationContext, "Uploading", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }
    override fun onBind(intent: Intent): IBinder? {
        return null;
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        //when the service is stopped, ths restarts it automatically.
        val intentToRestart = Intent(applicationContext, this.javaClass)
        intentToRestart.setPackage("com.elvis.backgroundservices")
        startService(intentToRestart)
        super.onTaskRemoved(rootIntent)
    }
}