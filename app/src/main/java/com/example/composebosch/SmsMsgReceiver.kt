package com.example.composebosch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log

class SmsMsgReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent?.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            val items: Array<SmsMessage> = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (item in items) {Log.d("smsmsgreceiver", item.messageBody+"phno--"+item.originatingAddress)}
        }    }
}