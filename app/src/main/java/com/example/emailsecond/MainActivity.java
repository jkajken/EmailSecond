package com.example.emailsecond;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etTheme, etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.EmailEditText);
        etTheme = findViewById(R.id.themeEditText);
        etMessage = findViewById(R.id.messageEditText);
        btnSend = findViewById(R.id.sendButton);
        btnSend.setOnClickListener(view -> {
            String emailsend = etEmail.getText().toString();
            String emailsubject = etTheme.getText().toString();
            String emailbody = etMessage.getText().toString();
            if (!etEmail.getText().toString().isEmpty() && !etTheme.getText().toString().isEmpty() &&
                    !etMessage.getText().toString().isEmpty()) {

                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser as Email client using createChooser function
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }else {
                Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();

            }
        })
;}}