package com.example.cityguideapp.Commen.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguideapp.R;

import java.util.Calendar;


public class Signup2ndScreen extends AppCompatActivity {

    ImageView backBtn;
    TextView titleText;
    Button btnLogin, btnNext;

    RadioGroup radioGroup;
    RadioButton selectRadio;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2nd_screen);

        idCommpont();

    }


    private void idCommpont() {
        backBtn = findViewById(R.id.signup_back_button);
        titleText = findViewById(R.id.signTitle);
        btnLogin = findViewById(R.id.btnLogin);
        btnNext = findViewById(R.id.btnNext);

        radioGroup = findViewById(R.id.groupRadio);
        datePicker = findViewById(R.id.datePiker);
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;
        if (isAgeValid < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    public void callNextSignupScreen(View view) {

        if (!validateGender()| !validateAge() ) {
            return;
        }

        selectRadio = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender =  selectRadio.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String _date = day+"/"+month+"/"+year;

        Intent intent = new Intent(getApplicationContext(), Signup3rdScreen.class);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[2] = new Pair<View, String>(btnLogin, "transition_login_btn");
        pairs[3] = new Pair<View, String>(btnNext, "transition_next_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2ndScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }
}