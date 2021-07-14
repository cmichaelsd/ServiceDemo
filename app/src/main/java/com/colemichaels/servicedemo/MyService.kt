package com.colemichaels.servicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {
    companion object {
        const val TAG = "ServiceExample"
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        Log.i(TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        coroutineScope.launch(Dispatchers.Default) {
            performTask(startId)
        }

        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i(TAG, "Service onBind")
        TODO("Return the communication channel to the service.")
    }

    private suspend fun performTask(startId: Int) {
        Log.i(TAG, "Service onStartCommand " + startId)

        var i = 0
        while (i++ <= 3) {
            try {
                delay(10_000)
            } catch (e: Exception) {
                // Do nothing
            }
            Log.i(TAG, "Service running " + startId)
        }
    }

}