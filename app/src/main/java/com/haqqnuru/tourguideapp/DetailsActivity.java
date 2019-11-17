package com.haqqnuru.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // set actionbar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tabs)));

        // stores the intent message(extras)
        Bundle intent = getIntent().getExtras();

        // set image on to DetailsActivity
        ImageView detailsImage = findViewById(R.id.details_Image);
        int image = intent.getInt(getResources().getString(R.string.image));
        detailsImage.setImageResource(image);

        // set name on to DetailsActivity
        TextView detailsName = findViewById(R.id.details_name);
        String name = intent.getString(getResources().getString(R.string.name));
        detailsName.setText(name);

        // set location on to DetailsActivity
        TextView detailsLocation = findViewById(R.id.details_location);
        String location = intent.getString(getResources().getString(R.string.location));
        detailsLocation.setText(location);

        // set description on to DetailsActivity
        TextView detailsDescription = findViewById(R.id.details_description);
        String description = intent.getString(getResources().getString(R.string.description));
        detailsDescription.setText(description);
    }
}
