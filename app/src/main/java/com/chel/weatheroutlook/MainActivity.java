package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.maleProfile) ImageView mMaleProfile;
    @BindView(R.id.femaleProfile) ImageView mFemaleProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind(this);

        mMaleProfile.setOnClickListener(this);
        mFemaleProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mMaleProfile){
            Intent intent = new Intent(MainActivity.this,ApiActivity.class);
            intent.putExtra("gender","male");
            Log.i(TAG,"male avatar selected");
            startActivity(intent);
        }
        if (v==mFemaleProfile){
            Intent intent = new Intent(MainActivity.this,ApiActivity.class);
            intent.putExtra("gender","female");
            Log.i(TAG,"female avatar selected");
            startActivity(intent);
        }

    }
}
