package com.hma.nfc;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.hma.nfc.MainActivity.NurClick;

public class Nurse extends Activity {

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
            Toast.makeText(this, "Did Beatrice put up to this?", Toast.LENGTH_LONG).show();
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
    public void DocPassClick(View view){
        EditText passEditBox = findViewById(R.id.passEditBox);
        String DocPass = passEditBox.getText().toString();
        Intent doc = new Intent(getApplicationContext(),NFC.class);
        doc.putExtra("DocPass",DocPass);
        startActivity(doc);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
    }

}
