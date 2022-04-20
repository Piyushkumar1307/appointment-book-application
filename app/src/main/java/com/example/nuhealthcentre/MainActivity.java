package com.example.nuhealthcentre;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout mainnextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainnextbtn = (GridLayout) findViewById(R.id.mainnextbtn);

        setSingleEvent(mainnextbtn);

    }

    private void setSingleEvent(GridLayout mainnextbtn) {

        for (int i=0;i<mainnextbtn.getChildCount();i++)
        {
            CardView cardView =(CardView)mainnextbtn.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0)
                    {
                        Intent intent = new Intent(MainActivity.this, PhysicianActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==1)
                    {
                        Intent intent = new Intent(MainActivity.this, ImmuneActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==2)
                    {
                        Intent intent = new Intent(MainActivity.this, CardiooActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==3)
                    {
                        Intent intent = new Intent(MainActivity.this, GastroActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==4)
                    {
                        Intent intent = new Intent(MainActivity.this, HemaActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==5)
                    {
                        Intent intent = new Intent(MainActivity.this, EmergencyActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==6)
                    {
                        Intent intent = new Intent(MainActivity.this, PsychoActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==7)
                    {
                        Intent intent = new Intent(MainActivity.this, EndocriActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }
}