package com.sukhmeet.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import com.sukhmeet.R;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 10/09/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class navigationActivity extends FragmentActivity {
    sectionPagerAdapter mySectionsPagerAdapter;// my helper  adapter class for sections/fragments
    ViewPager myViewPager; // to host my pages

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_main);

        mySectionsPagerAdapter = new sectionPagerAdapter(getSupportFragmentManager());
        // now this holds all my fragments
        myViewPager = (ViewPager) findViewById(R.id.pager);
        myViewPager.setAdapter(mySectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }
}