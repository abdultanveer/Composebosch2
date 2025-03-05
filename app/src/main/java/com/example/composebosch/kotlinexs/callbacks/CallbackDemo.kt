package com.example.composebosch.kotlinexs.callbacks

import kotlinx.coroutines.delay

class CallbackDemo {

    fun rekaAdd(a:Int,b:Int):Int{
        return a+b
    }
    fun muraliAdd(a:Int,b:Int,myPhno:MyPhoneNum){
        Thread.sleep(5000)
        myPhno.onSuccess(a+b)
    }
}