package com.hma.nfc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.hma.nfc.MainActivity.NurClick;

public class Nurse extends Activity {

    public void backbuttonn(View view){

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("logged_in", false).apply();
        finish();
    }

    public void NurPassClick(View view){
        EditText passEditBox = findViewById(R.id.passEditBox);
        if (isEmpty(passEditBox)){
            Toast.makeText(this, "Please Enter The Password", Toast.LENGTH_SHORT).show();
        }
        else{
            String DocPass = passEditBox.getText().toString();
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("pass", DocPass).apply();
            sharedPreferences.edit().putBoolean("logged_in", true).apply();
            Intent nfc = new Intent(getApplicationContext(),NFC.class);
            nfc.putExtra("DocPass",DocPass);
            startActivity(nfc);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
    }
    public void NurCharClick(View view){
        NurClick++;
        if (NurClick == 1){
            Toast.makeText(this, "Oh, Hello There!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 2){
            Toast.makeText(this, "How are you doing?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 3){
            Toast.makeText(this, "Ready to save lives?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 4){
            Toast.makeText(this, "Could you maybe, stop doing that?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 5){
            Toast.makeText(this, "That's really starting to bother me so.", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 6){
            Toast.makeText(this, "Would you stop molesting me!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 7){
            Toast.makeText(this, "Did Beatrice put you up to this?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 8){
            Toast.makeText(this, "I have a needle, and I'm not afraid to use it!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick == 9){
            Toast.makeText(this, "That's it, I'm telling the doc!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick >= 10){
            Toast.makeText(this, "Stop it!", Toast.LENGTH_LONG).show();
        }

    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }



}
