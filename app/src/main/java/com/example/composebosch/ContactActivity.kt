package com.example.composebosch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    lateinit var etContact:EditText
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
}