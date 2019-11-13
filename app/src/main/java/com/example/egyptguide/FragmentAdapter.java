package com.example.egyptguide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int mFragNum;
    private Context mContext;

    @Override
    public int getCount() {
        return mFragNum;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getStringArray(R.array.Fragments_names)[position];
    }

    public FragmentAdapter(@NonNull FragmentManager fm, Context context, int fragNum) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
        mFragNum = fragNum;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        // return POSITION_NONE to update all fragments every it's notified
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new Hotels();
        else if (position == 1)
            return new Restaurants();
        else if (position == 2)
            return new Entertainments();
        else if (position == 3)
            return new Banks();
        else if (position == 4)
            return new Universities();
        else
            return null;
    }
}
