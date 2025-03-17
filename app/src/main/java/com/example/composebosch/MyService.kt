package com.example.composebosch

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val aidlBinder = object : IMyAidlInterface.Stub(){
        override fun add(a: Int, b: Int): Int {
            return a+b+30
        }

        override fun getTyrePressure(): Int {
            return  45
        }
    }

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

    fun getTyrePressure():Int{
        return 35
    }

    override fun onBind(intent: Intent): IBinder {  //2
       // return servbinder //2

        return  aidlBinder
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