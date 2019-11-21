package com.chel.weatheroutlook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class rate extends AppCompatActivity  {
    private RatingBar ratingBar ;
    private Button Submit_button;
    private TextView RateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rate );


        ratingBar = findViewById(R.id.ratingBar);
        Submit_button = findViewById(R.id.Submit_button);
        RateTextView = findViewById(R.id.RateTextView);

        Submit_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RateTextView.setText( "your rating is; " + ratingBar.getRating() );
            }
        } );
    }
}
