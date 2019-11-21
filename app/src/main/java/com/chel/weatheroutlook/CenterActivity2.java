package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CenterActivity2 extends AppCompatActivity {
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardView5;
    private CardView cardView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center2);

        cardView1 = (CardView)  findViewById(R.id.button1);
        cardView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,SearchActivity.class);
                startActivity(intent);
            }
        });


        cardView2 = (CardView)  findViewById(R.id.Button2);
        cardView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,LocationAtivity.class);
                startActivity(intent);
            }
        });


        cardView3 = (CardView)  findViewById(R.id.Button3);
        cardView3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,NavigationActivity.class);
                startActivity(intent);
            }
        });


        cardView4 = (CardView)  findViewById(R.id.Button4);
        cardView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,RateActivity.class);
                startActivity(intent);
            }
        });


        cardView5 = (CardView)  findViewById(R.id.Button5);
        cardView5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,LanguageActivity.class);
                startActivity(intent);
            }
        });


        cardView6 = (CardView)  findViewById(R.id.Button6);
        cardView6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CenterActivity2.this,PrivateActivity.class);
                startActivity(intent);
            }
        });

    }
}
