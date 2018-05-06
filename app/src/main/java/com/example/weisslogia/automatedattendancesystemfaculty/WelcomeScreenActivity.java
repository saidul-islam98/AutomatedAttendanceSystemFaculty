package com.example.weisslogia.automatedattendancesystemfaculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//packages required for running nfc

import android.nfc.NfcAdapter;
import android.widget.Toast;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter==null)
        {
            Toast.makeText(this,"Sorry, your device doesn't support NFC",Toast.LENGTH_LONG).show();
            return;
        }
        if (!nfcAdapter.isEnabled())
        {
            Toast.makeText(this,"Please enable NFC from your device settings",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Congratulations! You are ready to run this app.",Toast.LENGTH_LONG).show();
        }
    }

    public void loginButtonClicked(View view)
    {
        Intent i = new Intent(this, Courses.class);
        startActivity(i);
    }

    public void signupButtonClicked(View view)
    {
        Intent i = new Intent(this,FacultySignupActivity.class);
        startActivity(i);
    }

    public void adminModeClicked(View view)
    {
        Intent i = new Intent(this,ViewFacultyDatabase.class);
        startActivity(i);
    }
}