import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//only a suspend fn can invoke another suspend fn
//or a coroutine can invoke a suspend fn
 fun main() {
     runBlocking { //synchronous

         println("weather forecast")
         printForecast()
         printTemp()

     }
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
