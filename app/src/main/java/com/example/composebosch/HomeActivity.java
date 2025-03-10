package com.example.composebosch;

import android.content.Intent;
import android.os.Bundle;
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
        Intent drIntent = new Intent(this,DiceRollActivity.class);
        drIntent.putExtra("pn","987654123456");
        startActivity(drIntent);
    }
}