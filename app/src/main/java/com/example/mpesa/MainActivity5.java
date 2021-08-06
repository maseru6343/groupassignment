package com.example.mpesa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void thahbieh(View view) {
        Intent intent = new Intent(this, MainActivity6.class);


        startActivity(intent);


    }

    public void mpesa(View view) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}