package com.hma.nfc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.hma.nfc.MainActivity.DocClick;
import static com.hma.nfc.MainActivity.NurClick;

public class Doctor extends Activity {

    public void backbuttond(View view){

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("logged_in", false).apply();
        finish();
    }
    public void DocPassClick(View view){
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
    public void DocCharClick(View view){
        DocClick++;
        if (NurClick >= 9 && DocClick == 1){
            Toast.makeText(this, "Oh wow, It's The Molester!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick >= 9 && DocClick == 2){
            Toast.makeText(this, "What the hell are you doing here?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick >= 9 && DocClick == 3){
            Toast.makeText(this, "You dare show you're face here again!!?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick >= 9 && DocClick >= 4){
            Toast.makeText(this, "That's it!, I'm gonna kill ya!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Sup Doc!", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

}
