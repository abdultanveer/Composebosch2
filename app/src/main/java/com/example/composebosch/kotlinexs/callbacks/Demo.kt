package com.example.composebosch.kotlinexs.callbacks

class Demo {
}

fun main() {
    var callbackDemo = CallbackDemo()
    var result = callbackDemo.rekaAdd(20,30)
    println("rekha's result --"+result)
    var myPhoneNum = MySecratary()
    callbackDemo.muraliAdd(20,30,myPhoneNum)
}