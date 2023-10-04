package com.example.programacionmovil13p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btncreate, btnlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btncreate = findViewById(R.id.btncreate);
        btnlist = findViewById(R.id.btnlist);
/*Creacion de los listener de los botones */

        btncreate.setOnClickListener(view -> {
            Intent intentcreate = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentcreate);
        });

        btnlist.setOnClickListener(view -> {
            Intent intentcreate = new Intent(getApplicationContext(), ActivityList.class);
            startActivity(intentcreate);
        });
    }
}