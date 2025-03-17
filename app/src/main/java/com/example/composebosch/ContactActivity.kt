package com.example.composebosch

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    lateinit var etContact:EditText

   lateinit var myService:MyService  //im not instantiating it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        etContact = findViewById(R.id.etContact)
    }

    fun sendDataParent(view: View) {
        val calIntent = Intent("bosch.calendar.launch")
        startActivity(calIntent)
//        var phno = etContact.text.toString()
//        var resIntent = Intent()
//        resIntent.putExtra("ph",phno)
//        setResult(RESULT_OK,resIntent)//RESULT_OK
//        finish()
    }

    fun startMyService(view: View) {
        var serIntent = Intent(this,MyService::class.java)
       // startService(serIntent)
        Log.i(TAG,"binding to a service")
        bindService(serIntent,serConnection, BIND_AUTO_CREATE) //1
    }

    //binder = pipe unix

    val serConnection = object :ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, servbinder: IBinder?) {  //3
            Log.i(TAG,"onServiceConnected/ bounded to the service")
            val binder = servbinder as MyService.LocalBinder
            myService = binder.getService()
           var result = myService.add(10,30)
            Log.i(TAG,"service result =  $result")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.i(TAG,"onServiceDisconnected  to the service")
        }
    }


    fun stopMyService(view: View) {
        var serIntent = Intent(this,MyService::class.java)
       // stopService(serIntent)
        unbindService(serConnection)
    }


    companion object{
        var TAG = ContactActivity::class.java.simpleName
    }
}