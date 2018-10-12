package com.hma.nfc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hma.nfc.R;

public class MainActivity extends AppCompatActivity {

    boolean doctor;
    public static int DocClick;
    public static int NurClick ;
    public void ClickDoctor (View view){
        doctor=true;
        Intent doc = new Intent(getApplicationContext(),Doctor.class);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("doctor", doctor).apply();
        startActivity(doc);
    }
    public void ClickNurse (View view){
        doctor=false;
        Intent nur = new Intent(getApplicationContext(),Nurse.class);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("doctor", doctor).apply();
        startActivity(nur);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("logged_in",false)){
            Intent nfc = new Intent(getApplicationContext(),NFC.class);
            startActivity(nfc);
        }

    }
}
