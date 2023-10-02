package com.example.cityguideapp.Commen.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.cityguideapp.R;

public class Signup3rdScreen extends AppCompatActivity {

    Button btnLogin, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup3rd_screen);

        btnNext = findViewById(R.id.btnNext);

    }

    public void callPhone(View view) {

        Intent intent = new Intent(getApplicationContext(), VerifiyOTP.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(btnNext, "transition_next_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup3rdScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }
}