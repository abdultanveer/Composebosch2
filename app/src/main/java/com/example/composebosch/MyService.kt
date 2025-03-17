package com.example.composebosch

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val  servbinder = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service  created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service  destroyed")

    }

    fun add(a:Int,b:Int):Int{
        return a + b
    }

    override fun onBind(intent: Intent): IBinder {  //2
        return servbinder //2
    }

    inner class LocalBinder : Binder() {

        fun getService():MyService{
            return this@MyService //4
        }
    }



        companion object{
        var TAG = MyService::class.java.simpleName
    }
}