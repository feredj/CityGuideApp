package com.example.cityguideapp.Commen.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;


public class SignUp extends AppCompatActivity {

    ImageView backBtn;
    TextView titleText;
    Button btnLogin, btnNext;

    TextInputLayout textName, textUser, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        idCommpont();


    }

    private void idCommpont() {
        backBtn = findViewById(R.id.signup_back_button);
        titleText = findViewById(R.id.signTitle);
        btnLogin = findViewById(R.id.btnLogin);
        btnNext = findViewById(R.id.btnNext);

        textName = findViewById(R.id.textFullName);
        textUser = findViewById(R.id.textUserName);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
    }

    private boolean validateFullName() {
        String val = textName.getEditText().toString().trim();

        if (val.isEmpty()) {
            textName.setError("Filed can not be empty");
            return false;
        } else {
            textName.setError(null);
            textName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUserName() {
        String val = textUser.getEditText().toString().trim();
        String chekspaces = "Aw{1,20}z";

        if (val.isEmpty()) {
            textUser.setError("Filed can not be empty");
            return false;
        } else if (val.length() > 20) {
            textUser.setError("Usernale is too large");
            return false;
        } else if (!val.matches(chekspaces)) {
            textUser.setError("No white spaces are allowed");
            return false;
        } else {
            textUser.setError(null);
            textUser.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = textEmail.getEditText().toString().trim();
        String chekemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            textEmail.setError("Filed can not be empty");
            return false;
        } else if (!val.matches(chekemail)) {
            textEmail.setError("Inalid Email");
            return false;
        } else {
            textName.setError(null);
            textName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = textEmail.getEditText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            textEmail.setError("Password contien 4 charcter");
            return false;
        } else {
            textEmail.setError(null);
            textEmail.setErrorEnabled(false);
            return true;
        }
    }

    public void callNextSignupScreen(View view) {



        Intent intent = new Intent(getApplicationContext(), Signup2ndScreen.class);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[2] = new Pair<View, String>(btnLogin, "transition_login_btn");
        pairs[3] = new Pair<View, String>(btnNext, "transition_next_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());
    }
}