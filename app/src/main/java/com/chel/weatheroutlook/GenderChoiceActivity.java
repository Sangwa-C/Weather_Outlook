package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenderChoiceActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.maleProfile) ImageView mMaleProfile;
    @BindView(R.id.femaleProfile) ImageView mFemaleProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_choice);
        ButterKnife.bind(this);

        mFemaleProfile.setOnClickListener(this);
        mMaleProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mMaleProfile){
            Intent intent = new Intent(GenderChoiceActivity.this,MainActivity.class);
            startActivity(intent);
        }
        if (v==mFemaleProfile){
            Intent intent = new Intent(GenderChoiceActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
