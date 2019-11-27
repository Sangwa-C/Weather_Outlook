package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class MainApplication extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext( LocalHelper.onAttach( base, "en" ) );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
    }
}
