package com.example.composebosch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity {
public  static String TAG = HomeActivity.class.getSimpleName();
TextView textView;

public static  int REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.textView);
    }

    public void clickHandler(View view) {
        Log.i(TAG,"button was clicked");
        ConstraintLayout constraintLayout = findViewById(R.id.conslayout);
        Snackbar.make(constraintLayout,"button was clicked",Snackbar.LENGTH_SHORT).show();
        Intent drIntent = new Intent(this,DiceRollActivity.class); //explicit intent
        drIntent.putExtra("pn","987654123456");
        startActivity(drIntent);
    }

    public void dialNo(View view) {
        Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:987654312"));//implicit intent
        startActivity(dIntent);
    }


    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void setAlarm(View view) {
        createAlarm("bosch2batch",14,57);
    }

    public void getContact(View view) {
        Intent cIntent = new Intent(this,ContactActivity.class);
        startActivityForResult(cIntent,REQUEST_CODE);
    }

    //common return -- receptionist
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resIntent) {
        super.onActivityResult(requestCode, resultCode, resIntent);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String contact = resIntent.getStringExtra("ph");
            textView.setText(contact);
        }
    }
}