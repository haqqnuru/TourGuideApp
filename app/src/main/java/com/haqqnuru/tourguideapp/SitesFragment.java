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


public class SitesFragment extends Fragment {

    // fragment constructor
    public SitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // creating tourist site array list
        ArrayList<TourGuide> sites = new ArrayList<>();

        sites.add(new TourGuide(R.drawable.kakum, getResources().getString(R.string.kakumpark),
                getResources().getString(R.string.kakum), getResources().getString(R.string.kakum_des)));
        sites.add(new TourGuide(R.drawable.fortamsterdam, getResources().getString(R.string.fortamst),
                getResources().getString(R.string.kormantin), getResources().getString(R.string.fortamst_des)));
        sites.add(new TourGuide(R.drawable.fortwilliam, getResources().getString(R.string.fortwill),
                getResources().getString(R.string.anomabu), getResources().getString(R.string.fortwill_des)));
        sites.add(new TourGuide(R.drawable.capecoast, getResources().getString(R.string.capecast),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.capecastle_des)));
        sites.add(new TourGuide(R.drawable.elimina, getResources().getString(R.string.elminacast),
                getResources().getString(R.string.elmina), getResources().getString(R.string.eliminacastle_des)));
        sites.add(new TourGuide(R.drawable.fortpatience, getResources().getString(R.string.fortpat),
                getResources().getString(R.string.apam), getResources().getString(R.string.forpatience_des)));
        sites.add(new TourGuide(R.drawable.fortnassau, getResources().getString(R.string.fortnas),
                getResources().getString(R.string.moree), getResources().getString(R.string.fornassau_des)));
        sites.add(new TourGuide(R.drawable.fortcoenraadsburg, getResources().getString(R.string.fortco),
                getResources().getString(R.string.elmina), getResources().getString(R.string.forcoen_des)));
        sites.add(new TourGuide(R.drawable.fortvic, getResources().getString(R.string.fortvic),
                getResources().getString(R.string.capecoast), getResources().getString(R.string.forvic_des)));
        sites.add(new TourGuide(R.drawable.forgoe, getResources().getString(R.string.fortgo),
                getResources().getString(R.string.senyaberaku), getResources().getString(R.string.fordeg_des)));

        // ArrayAdopter
        TourGuideAdapter Adapter =
                new TourGuideAdapter(getActivity(), sites, R.color.relRed);

        // calling the listView variable
        ListView listView = rootView.findViewById(R.id.tourList);

        // setting adopter to the listView
        listView.setAdapter(Adapter);

        // calling onclicklister to make the listView clickable and open an intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the selected site
                TourGuide selectedlist = (TourGuide) adapterView.getItemAtPosition(i);

                int tourImage = selectedlist.getImage();
                String tourname = selectedlist.getName();
                String tourLocation = selectedlist.getLocation();
                String tourDescription = selectedlist.getDescription();

                // passing the selected site to DetailsActivity class
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
