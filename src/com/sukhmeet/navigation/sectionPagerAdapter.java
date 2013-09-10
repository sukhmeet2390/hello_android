package com.sukhmeet.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.sukhmeet.R;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 10/09/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class sectionPagerAdapter extends FragmentPagerAdapter {
    public sectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new pageFragment();
        Bundle args = new Bundle();
        args.putInt(pageFragment.ARG_SECTION_NUMBER, position+1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "sequence"+ ((position) % 3) ;
    }

    @Override
    public int getCount() {
        return 3;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
