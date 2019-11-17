package com.haqqnuru.tourguideapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    // fragment constructor
    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // creating hotels array list
        ArrayList<TourGuide> hotels = new ArrayList<>();

        hotels.add(new TourGuide(R.drawable.oasis, getResources().getString(R.string.oasis),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.oasis_des)));
        hotels.add(new TourGuide(R.drawable.almondtree, getResources().getString(R.string.almond),
                getResources().getString(R.string.elmina), getResources().getString(R.string.almond_des)));
        hotels.add(new TourGuide(R.drawable.rainforest, getResources().getString(R.string.rainforest),
                getResources().getString(R.string.akrofrom), getResources().getString(R.string.rainforest_des)));
        hotels.add(new TourGuide(R.drawable.brenu, getResources().getString(R.string.brenu),
                getResources().getString(R.string.elmina), getResources().getString(R.string.brenu_des)));
        hotels.add(new TourGuide(R.drawable.eliminabay, getResources().getString(R.string.elminabay),
                getResources().getString(R.string.elmina), getResources().getString(R.string.eliminabay_des)));
        hotels.add(new TourGuide(R.drawable.anomabo, getResources().getString(R.string.anomabobeach),
                getResources().getString(R.string.anomabu), getResources().getString(R.string.anomabobeach_des)));
        hotels.add(new TourGuide(R.drawable.loreto, getResources().getString(R.string.loreto),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.loreto_des)));
        hotels.add(new TourGuide(R.drawable.marrets, getResources().getString(R.string.marrets)
                , getResources().getString(R.string.capecoast), getResources().getString(R.string.marrets_des)));

        // ArrayAdopter
        TourGuideAdapter Adapter =
                new TourGuideAdapter(getActivity(), hotels, R.color.green);

        // calling the listView variable
        ListView listView = rootView.findViewById(R.id.tourList);

        // setting adopter to the listView
        listView.setAdapter(Adapter);

        // calling onclicklister to make the listView clickable and pass an intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the selected hotel
                TourGuide selectedlist = (TourGuide) adapterView.getItemAtPosition(i);

                int tourImage = selectedlist.getImage();
                String tourname = selectedlist.getName();
                String tourLocation = selectedlist.getLocation();
                String tourDescription = selectedlist.getDescription();

                // passing the selected hotel to DetailsActivity class
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(getResources().getString(R.string.image), tourImage);
                intent.putExtra(getResources().getString(R.string.name), tourname);
                intent.putExtra(getResources().getString(R.string.location), tourLocation);
                intent.putExtra(getResources().getString(R.string.description), tourDescription);
                startActivity(intent);
            }
        });

        return rootView;
    }
}