package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class ClothingActivity extends AppCompatActivity {
    public static final String TAG = ClothingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        String maxStringTemp = intent.getStringExtra("maxTemp");
        String minStringTemp = intent.getStringExtra("minTemp");
        String gender = intent.getStringExtra("gender");

        Double mMaxTemp = Double.parseDouble(maxStringTemp);
        Double mMinTemp = Double.parseDouble(minStringTemp);
    }
}
