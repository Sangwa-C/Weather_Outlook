package com.chel.weatheroutlook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
//    public  nav_rate
//    @BindView(R.id.clothesTextView) TextView mClothesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

////        Intent intent = getIntent();
////        String locationName = intent.getStringExtra("locationName");
////
//////        mClothesTextView.setText("For this search "  + " ' "  + locationName   + " ' " + " we have: ");
//
//        Toast.makeText(MainActivity.this, locationName, Toast.LENGTH_LONG).show();

        mDrawerLayout = findViewById( R.id.activity_main);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener( mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nvDrawer = (NavigationView) findViewById( R.id.nav_header );
        setupDrawerContent(  nvDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (mToggle.onOptionsItemSelected( item )){
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    public boolean selectItemDrawer(MenuItem menuItem){
//        Fragment myFragment = null;
//        Class fragmentClass;
//        switch (menuItem.getItemId()){
//            case R.id.nav_location:
//                fragmentClass = Edit_location.class;
//                break;
//
//            case R.id.nav_language:
//                fragmentClass = Language.class;
//                break;
//
//            case R.id.nav_settings:
//                fragmentClass = Settings.class;
//                break;
//
//            case R.id.nav_help:
//                fragmentClass = Help.class;
//                break;
//
//            case R.id.nav_rate:
//                fragmentClass = Rate.class;
//                break;
//
//            default:
//                fragmentClass = Edit_location.class;
//        }
//        try {
//            myFragment = (Fragment) fragmentClass.newInstance();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.f1content,myFragment).commit();
        menuItem.setChecked( true );
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();

        int id = menuItem.getItemId();

        if (id == R.id.nav_language){
            Intent intent = new Intent( MainActivity.this, Language_1.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_rate){
            Intent intent = new Intent( MainActivity.this, rate.class );
            startActivity( intent );
            return true;
        }

        return false;
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return true;
            }
        } );{

        }
    }

//       if(v == mFindMallButton) {
//        String location = mLocationEditText.getText().toString();
//        saveLocationToFirebase(location);
//        Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
//        cheHome.putExtra("kigali", location);
//        startActivity(cheHome);
//    }


}
