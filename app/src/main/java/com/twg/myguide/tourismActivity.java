package com.twg.myguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tourismActivity extends AppCompatActivity {
    Button btnhill,btnbeach,btnrafting,btnhist,btnsolo,btnadv,btndelhi,btnSea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        btnhill = findViewById(R.id.buttonHilly);
        btnbeach = findViewById(R.id.buttonBeach);
        btnrafting = findViewById(R.id.buttonRafting);
        btnhist = findViewById(R.id.buttonHistory);
        btnsolo = findViewById(R.id.buttonSolo);
        btnadv = findViewById(R.id.buttonAdventure);
        btndelhi = findViewById(R.id.buttonDelhi);
        btnSea = findViewById(R.id.buttonSea);
        btnhill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "hill";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);
            }
        });
        btnbeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "beach";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btnrafting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "raft";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btnhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "hist";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btnsolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "solo";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btnadv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "adv";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btndelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "delhi";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });
        btnSea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "sea";
                Intent intent = new Intent(tourismActivity.this,tourWebActivity.class);
                intent.putExtra("place",type);
                startActivity(intent);

            }
        });

    }
}