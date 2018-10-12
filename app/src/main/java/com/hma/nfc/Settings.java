package com.hma.nfc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void backbuttons(View view){
        finish();
    }
    public void save(View view){
        EditText ipEditText = findViewById(R.id.ip);
        if (isEmpty(ipEditText)){
            Toast.makeText(this, "Please Enter The IP", Toast.LENGTH_SHORT).show();
        }
        else{
            String ip = ipEditText.getText().toString();
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("ip", ip).apply();
            Intent nfc = new Intent(getApplicationContext(),NFC.class);
            startActivity(nfc);
        }
        
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

}
