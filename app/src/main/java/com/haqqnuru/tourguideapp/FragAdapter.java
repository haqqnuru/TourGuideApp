package com.haqqnuru.tourguideapp;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragAdapter extends FragmentPagerAdapter {

    //context variable
    private Context fragContext;

    public FragAdapter(Context context, FragmentManager fm) {
        super(fm);
        fragContext = context;
    }

    // set positions of fragment on tab and view pager
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SitesFragment();
        } else if (position == 1) {
            return new HotelsFragment();
        } else if (position == 2) {
            return new SchoolsFragment();
        } else {
            return new FestivalsFragment();
        }
    }

    // sets the length of fragments (number of fragments)
    @Override
    public int getCount() {
        return 4;
    }

    //sets page title on tabs
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return fragContext.getString(R.string.sites);
        } else if (position == 1) {
            return fragContext.getString(R.string.hotels);
        } else if (position == 2) {
            return fragContext.getString(R.string.schools);
        } else {
            return fragContext.getString(R.string.festivals);
        }
    }
}
