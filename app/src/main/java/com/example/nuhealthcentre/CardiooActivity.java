package com.example.nuhealthcentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CardiooActivity extends AppCompatActivity {

    ImageView backBtn;
    Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardioo);

        button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMain();
            }
        });

        button1 = findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMain1();
            }
        });



        //Hooks

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardiooActivity.super.onBackPressed();
            }
        });

    }
    public void openActivityMain(){
        Intent intent = new Intent(this, MohitActivity.class);
        startActivity(intent);
    }

    public void openActivityMain1(){
        Intent intent = new Intent(this, dummy1Activity.class);
        startActivity(intent);
    }
}