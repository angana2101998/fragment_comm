package com.example.fragmentui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter implements IAdapter {

    private List<ITabbedFragment> fragments;

    private static final String[] TAB_TITLES = {
            "Fragment 1",
            "Fragment 2"
    };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
        fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance(this));
        fragments.add(BlankFragment2.newInstance(this));
        //fragments.add(BlankFragment.newInstance(this));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (Fragment) fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void onSend(Object o, Fragment fragment) {
        for (ITabbedFragment f: fragments){
            if (!f.equals(fragment)) f.onReceive(o);
        }
    }
}
