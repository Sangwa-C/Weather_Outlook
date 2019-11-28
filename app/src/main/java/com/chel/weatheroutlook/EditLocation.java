package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import butterknife.BindView;

public class EditLocation extends AppCompatActivity implements View.OnClickListener {
    private Button findLocationButton;
    private EditText typedLocation;

//    @BindView(R.id.findLocationButton) Button mfindLocationButton;
//    @BindView(R.id.typedLocation) EditText typedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_location );

        findLocationButton = findViewById( R.id.findLocationButton );
        typedLocation = findViewById( R.id.typedLocation );
        findLocationButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if (v == findLocationButton) {
            String clothType = typedLocation.getText().toString();
            Intent cheHome = new Intent(EditLocation.this, MainActivity.class);
            Toast.makeText(EditLocation.this, "" + clothType, Toast.LENGTH_SHORT).show();
            cheHome.putExtra("clothType", clothType);
            startActivity(cheHome);
        }
    }
}
