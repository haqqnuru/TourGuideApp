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

public class FestivalsFragment extends Fragment {

    // fragment constractor
    public FestivalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // creating festivals array list
        ArrayList<TourGuide> festivals = new ArrayList<>();

        festivals.add(new TourGuide(R.drawable.aboakyer, getResources().getString(R.string.aboakye),
                getResources().getString(R.string.winneba), getResources().getString(R.string.aboakyir_des)));
        festivals.add(new TourGuide(R.drawable.masquerade, getResources().getString(R.string.masquerading),
                getResources().getString(R.string.winneba), getResources().getString(R.string.masquerading_des)));
        festivals.add(new TourGuide(R.drawable.bronya, getResources().getString(R.string.bronya),
                getResources().getString(R.string.elmina), getResources().getString(R.string.bronya_des)));
        festivals.add(new TourGuide(R.drawable.bakatue, getResources().getString(R.string.bakatue),
                getResources().getString(R.string.elmina), getResources().getString(R.string.bakatue_des)));
        festivals.add(new TourGuide(R.drawable.akwambo, getResources().getString(R.string.akwambo),
                getResources().getString(R.string.agona), getResources().getString(R.string.akwambo_des)));
        festivals.add(new TourGuide(R.drawable.panafest, getResources().getString(R.string.panafest),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.panafest_des)));
        festivals.add(new TourGuide(R.drawable.odwira, getResources().getString(R.string.odwira),
                getResources().getString(R.string.jukwa), getResources().getString(R.string.odwira_des)));
        festivals.add(new TourGuide(R.drawable.afahye, getResources().getString(R.string.afahye),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.afahye_des)));
        festivals.add(new TourGuide(R.drawable.okyir, getResources().getString(R.string.okyir),
                getResources().getString(R.string.anomabu), getResources().getString(R.string.okyir_des)));

        // ArrayAdopter
        TourGuideAdapter Adapter =
                new TourGuideAdapter(getActivity(), festivals, R.color.safty_orange);

        // calling the listView variable
        ListView listView = rootView.findViewById(R.id.tourList);

        // setting adopter to the listView
        listView.setAdapter(Adapter);

        // calling onclicklister to make the listView clickable and pass an intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the selected festival
                TourGuide selectedlist = (TourGuide) adapterView.getItemAtPosition(i);

                int tourImage = selectedlist.getImage();
                String tourname = selectedlist.getName();
                String tourLocation = selectedlist.getLocation();
                String tourDescription = selectedlist.getDescription();

                // passing the selected festival to DetailsActivity class
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