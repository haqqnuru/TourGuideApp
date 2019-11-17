package com.haqqnuru.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TourGuideAdapter extends ArrayAdapter<TourGuide> {

    // resouce for background color to the list
    private int colorResource;

    public TourGuideAdapter(@NonNull Context context, ArrayList<TourGuide> tourGuide, int colorResource) {
        super(context, 0, tourGuide);
        this.colorResource = colorResource;
    }

    // gets and positions the view to be populated on list_items.xml
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the tourGuide object located at this position in the list
        TourGuide currentTourGuide = getItem(position);

        // Find the ImageView(placeImage) in the list_items.xml layout
        ImageView tourImage = convertView.findViewById(R.id.placeImage);
        // Get the image from the current tourGuide object and set image on the name tourImage
        tourImage.setImageResource(currentTourGuide.getImage());

        // Find the TextView(nameOfPlace) in the list_items.xml layout
        TextView placeName = convertView.findViewById(R.id.nameOfPlace);
        // Get the Name from the current tourGuide object and set text on the name placeName
        placeName.setText(currentTourGuide.getName());

        // Find the TextView(details_location) in the list_items.xml layout
        TextView location = convertView.findViewById(R.id.details_location);
        // Get the location from the current tourGuide object and set text on the name location
        location.setText(currentTourGuide.getLocation());

        // Find the TextView(description) in the list_items.xml layout
        TextView discription = convertView.findViewById(R.id.description);
        // Get the discription from the tourGuide object and set text on the name description
        discription.setText(currentTourGuide.getDescription());

        // set the theme color for list_items
        View Container = convertView.findViewById(R.id.colorContainer);
        // find the color that the resource connects to
        int color = ContextCompat.getColor(getContext(), colorResource);
        // sets the background color of the text container View
        Container.setBackgroundColor(color);

        // Returns the whole list_items layout containing 3 TextViews and an ImageView
        // so that it can be shown in the ListView
        return convertView;
    }
}
