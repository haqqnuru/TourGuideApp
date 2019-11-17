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

public class SchoolsFragment extends Fragment {

    // fragment constractor
    public SchoolsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // creating  schools array list
        ArrayList<TourGuide> schools = new ArrayList<>();

        schools.add(new TourGuide(R.drawable.mfantsipim, getResources().getString(R.string.mfantsipim),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.mfantsipim_des)));
        schools.add(new TourGuide(R.drawable.wesleygirls, getResources().getString(R.string.wesleygirls),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.wesley_des)));
        schools.add(new TourGuide(R.drawable.augustine, getResources().getString(R.string.augustine),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.augustine_des)));
        schools.add(new TourGuide(R.drawable.adisadel, getResources().getString(R.string.adisadel),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.adisadel_des)));
        schools.add(new TourGuide(R.drawable.apam, getResources().getString(R.string.apamshs),
                getResources().getString(R.string.apam), getResources().getString(R.string.apam_des)));
        schools.add(new TourGuide(R.drawable.holychild, getResources().getString(R.string.holychild),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.holychild_des)));

        // ArrayAdopter
        TourGuideAdapter Adapter =
                new TourGuideAdapter(getActivity(), schools, R.color.blue);

        // calling the listView variable
        ListView listView = rootView.findViewById(R.id.tourList);

        // setting adopter to the listView
        listView.setAdapter(Adapter);

        // calling onclicklister to make the listView clickable and open an intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the selected school
                TourGuide selectedlist = (TourGuide) adapterView.getItemAtPosition(i);

                int tourImage = selectedlist.getImage();
                String tourname = selectedlist.getName();
                String tourLocation = selectedlist.getLocation();
                String tourDescription = selectedlist.getDescription();

                // passing the selected school to DetailsActivity class
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
