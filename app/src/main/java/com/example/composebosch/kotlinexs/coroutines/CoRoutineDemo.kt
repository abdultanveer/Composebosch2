import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

//only a suspend fn can invoke another suspend fn
//or a coroutine can invoke a suspend fn
 fun main() {
     val time = measureTimeMillis {
         runBlocking { //synchronous

             println("weather forecast")
             launch {
                 //this coroutine[folder] is getting launched on  a seperate thread and starting the suspendable fn
                 printForecast()
             }
             launch {
                 printTemp()
             }
        println("end of runblocking")
         }
     }
    println("time taken -- ${time} mseconds")
}

suspend fun printForecast(){
    println("in printForecast ")
    delay(5000) //this function is suspended for 1 sec
    println("Sunny")
}

suspend fun printTemp(){
    println("in printTemp ")

    delay(1000)
    println("30\u00b0c")
}
