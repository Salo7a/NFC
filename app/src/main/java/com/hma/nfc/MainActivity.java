package com.hma.nfc;

import android.content.Intent;
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
        doc.putExtra("doctor",doctor);
        startActivity(doc);
    }
    public void ClickNurse (View view){
        doctor=false;
        Intent nur = new Intent(getApplicationContext(),Nurse.class);
        nur.putExtra("doctor",doctor);
        startActivity(nur);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
