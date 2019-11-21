package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CenterActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        button = (Button)  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CenterActivity2();
            }
        });

        }
        public void CenterActivity2(){
        Intent intent= new Intent(this, HelpActivity.class);
        startActivity(intent);
        }
    }

