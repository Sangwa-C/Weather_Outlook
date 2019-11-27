package com.chel.weatheroutlook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.Network;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    TextView textView2;

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


        textView2 = (TextView)findViewById( R.id.textView2 );

        Paper.init( this );

        String language = Paper.book().read("language");
        if (language==null)
            Paper.book().write( "language", "en" );
        
        updateView((String) Paper.book().read( "language" ));

    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this, lang);
        Resources resources = context.getResources();

        textView2.setText( resources.getString( R.string.textView2 ) );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (mToggle.onOptionsItemSelected( item )){
            return true;
        }

        if(item.getItemId() == R.id.language_en){
            Paper.book().write( "language", "en" );
            updateView( (String )Paper.book().read( "language" ));
        }

        if(item.getItemId() == R.id.language_vi){
            Paper.book().write( "language", "vi" );
            updateView( (String )Paper.book().read( "language" ));
        }



        return true;
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

            case R.id.nav_settings:
                fragmentClass = Settings.class;
                break;

            case R.id.nav_help:
                fragmentClass = Help.class;
                break;

            case R.id.nav_rate:
                fragmentClass = Rate.class;
                break;

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

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext( LocalHelper.onAttach( newBase, "en" ) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu,menu );
        return super.onCreateOptionsMenu( menu );
    }


    //       if(v == mFindMallButton) {
//        String location = mLocationEditText.getText().toString();
//        saveLocationToFirebase(location);
//        Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
//        cheHome.putExtra("kigali", location);
//        startActivity(cheHome);
//    }


}
