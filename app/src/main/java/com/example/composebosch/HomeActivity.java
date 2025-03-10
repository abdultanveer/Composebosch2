package com.example.composebosch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity {
public  static String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
}