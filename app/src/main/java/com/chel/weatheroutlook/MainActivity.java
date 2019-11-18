package com.chel.weatheroutlook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.location.Location;
import android.net.Network;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mDrawerLayout = findViewById( R.id.activity_main);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener( mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nvDrawer = (NavigationView) findViewById( R.id.nav_header );
//        setupDrawerContent(  nvDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (mToggle.onOptionsItemSelected( item )){
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    public void selectItemDrawer(MenuItem menuItem){
        Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.nav_location:
                fragmentClass = Edit_location.class;
                break;

            case R.id.nav_language:
                fragmentClass = Language.class;
                break;

            case R.id.nav_help:
                fragmentClass = Help.class;

            default:
                fragmentClass = Edit_location.class;
        }
        try {
            myFragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.f1content,myFragment).commit();
        menuItem.setChecked( true );
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }
//
//    private void setupDrawerContent(NavigationView navigationView){
//        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                selectItemDrawer(menuItem);
//                return true;
//            }
//        } );{
//
//        }
//    }
}
