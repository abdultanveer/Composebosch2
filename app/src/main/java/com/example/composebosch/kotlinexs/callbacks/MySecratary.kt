package com.example.composebosch.kotlinexs.callbacks

class MySecratary:MyPhoneNum {


    override fun onSuccess(result: Int) {

        println("i received the result --"+result)
    }
}