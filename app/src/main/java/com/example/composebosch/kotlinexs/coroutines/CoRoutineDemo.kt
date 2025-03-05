package com.example.composebosch.kotlinexs.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

class CoRoutineDemo {
}

// printForecast() printTemp() -- they are coperating because they are part off a coroutine[runblocking]
//only a suspendable fn can invoke another suspendable fn
//or a coroutine can invoke a suspendable fn
//https://play.kotlinlang.org/byExample/04_functional/01_Higher-Order%20Functions
 fun main() {
    var time = measureTime {

        //GlobalScope.launch {  }

     runBlocking {   //synchrounos

         println("weather forecast")
        // val a : Int = 10
        println(getWeatherReport())
         println("end of runblocking")
         }
     }
    println("execution time is $time ms")

}

suspend fun getWeatherReport()  = coroutineScope{
    //2 subtasks
    val forecast = async {   getForecast()}
    val temp =  async {  getTemp() }

    "${forecast.await()} ${temp.await()}"

}


 suspend fun getForecast():String{
     var a = 10
     println("entered printforecast")
    delay(5000)
     return "Sunny"

}

suspend fun getTemp():String{
    println("entered printTemp")
    delay(1000)
    return "30\u00b0c"

}