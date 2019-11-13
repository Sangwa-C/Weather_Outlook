package com.chel.weatheroutlook;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
//    private DrawerLayout mDrawerlayout;
//    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

//        mDrawerlayout = findViewById( R.id.activity_main);
//        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open, R.string.close);
//        mDrawerlayout.addDrawerListener( mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//
//        if (mToggle.onOptionsItemSelected( item )){
//            return true;
//        }
//
//        return super.onOptionsItemSelected( item );
//    }
}
