import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

//only a suspend fn can invoke another suspend fn
//or a coroutine can invoke a suspend fn
 fun main() {
    // val time = measureTimeMillis {
         runBlocking { //synchronous

             println("weather forecast")
             println(getWeatherReport())
             println("done with runblocking")
     }
}

suspend fun getWeatherReport() = coroutineScope{
    //get forecast --webservice
    val forecast = async { getForecast()}
    //get the temp  --query db
    val temp = async {  getTemp()}
    //return the concatenated data

    "${forecast.await()} ${temp.await()}"

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
