import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
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
           val forecast: Deferred<String> =  async {    //forecast="sunny"
                 //this coroutine[folder] is getting launched on  a seperate thread and starting the suspendable fn
                 getForecast()
             }
             val temp = async {
                 getTemp()
             }
        println("end of runblocking")
             println("${forecast.await()}  ${temp.await()}")
         }
     }
    println("time taken -- ${time} mseconds")
}

suspend fun getForecast():String{
    println("in printForecast ")
    delay(5000) //this function is suspended for 1 sec
    return "Sunny"
}

suspend fun getTemp():String{
    println("in printTemp ")

    delay(1000)
    return "30\u00b0c"
}
