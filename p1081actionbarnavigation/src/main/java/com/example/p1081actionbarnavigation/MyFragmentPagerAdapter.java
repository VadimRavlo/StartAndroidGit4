package com.example.p1081actionbarnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by administrator on 24.08.2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public MyFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return newInstance(position);
    }

    @Override
    public int getCount() {
        return Constants.PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }

    PageFragment newInstance(int page){
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(Constants.ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);

        return pageFragment;
    }
}
