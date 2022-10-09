package com.geektech.homework_3_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText gmail;
    EditText theme;
    EditText commit;
    Button buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmail = findViewById(R.id.ET_gmail);
        theme = findViewById(R.id.ET_theme);
        commit = findViewById(R.id.ET_commit);
        buttonSend = findViewById(R.id.btn_Send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gmail.getText().toString().isEmpty()&&!theme.getText().toString().isEmpty()&&
                        !commit.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{gmail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,commit.getText().toString());
                    intent.setType("message/rfc822");
                    if (intent.resolveActivity(getPackageManager()) !=null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });}}