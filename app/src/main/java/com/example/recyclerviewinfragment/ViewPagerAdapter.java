package com.example.recyclerviewinfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> array1 = new ArrayList<>();
    private final List<String> array2 = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }




    @Override
    public Fragment getItem(int position) {
        return array1.get(position);
    }

    @Override
    public int getCount() {
        return array2.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return array2.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        array1.add(fragment);
        array2.add(title);

    }






}
