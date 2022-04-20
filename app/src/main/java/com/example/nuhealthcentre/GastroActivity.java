package com.example.nuhealthcentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GastroActivity extends AppCompatActivity {

    ImageView backBtn;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endo);

        button = findViewById(R.id.btn11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMain();
            }
        });



        //Hooks

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GastroActivity.super.onBackPressed();
            }
        });

    }
    public void openActivityMain(){
        Intent intent = new Intent(this, AlexActivity.class);
        startActivity(intent);
    }
}