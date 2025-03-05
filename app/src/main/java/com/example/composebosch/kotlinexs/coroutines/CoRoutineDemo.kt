import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//only a suspend fn can invoke another suspend fn
//or a coroutine can invoke a suspend fn
 fun main() {
     runBlocking { //synchronous

         println("weather forecast")
         delay(5000) //this function is suspended for 1 sec
         println("Sunny")

     }
}