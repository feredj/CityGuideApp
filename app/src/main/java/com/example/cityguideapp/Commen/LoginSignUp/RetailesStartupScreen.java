package com.example.cityguideapp.Commen.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.cityguideapp.R;

public class RetailesStartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailes_startup_screen);

        if(isConnected(RetailesStartupScreen.this)){
            showCustomDialog();
        }
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RetailesStartupScreen.this);
        builder.setMessage("Please Connect the Internet to Proceed Further").setCancelable(false).setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(),RetailesStartupScreen.class));
            }
        });
    }

    public void callLoginPage(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btnLogin), "btnLogin");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailesStartupScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callSignPage(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btnLogin), "btnLogin");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailesStartupScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }

    private boolean isConnected(RetailesStartupScreen re) {
        ConnectivityManager connectivityManager = (ConnectivityManager) re.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if( (wifiCon != null && wifiCon.isConnected()) || (mobileCon != null && mobileCon.isConnected())){
            return  true;
        }else{
            return false;
        }
    }
}