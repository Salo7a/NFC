package com.hma.nfc;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.hma.nfc.MainActivity.DocClick;
import static com.hma.nfc.MainActivity.NurClick;

public class Doctor extends Activity {


    public void DocPassClick(View view){
        EditText passEditBox = findViewById(R.id.passEditBox);
        String DocPass = passEditBox.getText().toString();
        Intent doc = new Intent(getApplicationContext(),NFC.class);
        doc.putExtra("DocPass",DocPass);
        startActivity(doc);

    }
    public void DocCharClick(View view){
        DocClick++;
        if (NurClick <= 9 && DocClick == 1){
            Toast.makeText(this, "Oh wow, It's The Molester!", Toast.LENGTH_LONG).show();
        }
        else if (NurClick <= 9 && DocClick == 2){
            Toast.makeText(this, "What the hell are you doing here?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick <= 9 && DocClick == 3){
            Toast.makeText(this, "You dare show you're face here again!!?", Toast.LENGTH_LONG).show();
        }
        else if (NurClick <= 9 && DocClick >= 4){
            Toast.makeText(this, "That's it!, I'm gonna kill ya!", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Sup Doc!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);
    }

}
