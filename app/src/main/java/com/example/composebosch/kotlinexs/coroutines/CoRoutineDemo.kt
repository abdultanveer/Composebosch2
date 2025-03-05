package com.example.composebosch.kotlinexs.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class CoRoutineDemo {
}

// printForecast() printTemp() -- they are coperating because they are part off a coroutine[runblocking]
//only a suspendable fn can invoke another suspendable fn
//or a coroutine can invoke a suspendable fn
//https://play.kotlinlang.org/byExample/04_functional/01_Higher-Order%20Functions
 fun main() {
val time = measureTimeMillis {
    runBlocking {   //synchrounos
        println("weather forecast")
        printForecast()
        printTemp()
    }
}
println("Execution time ${time/1000} seconds")
}




 suspend fun printForecast(){
     println("entered printforecast")
    delay(5000)
    println("Sunny")

}

suspend fun printTemp(){
    println("entered printTemp")
    delay(1000)
    println("30\u00b0c")

}