package com.sukhmeet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 03/09/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);

        // Grab the instance of TabFragment that was included with the layout and have it
        // launch the initial tab.
        System.out.println("--------------------------ON CREATE MyFragmentActivity----------------");
        FragmentManager fm = getSupportFragmentManager();
        Fragment tabFragment = (TabFragment)fm.findFragmentById(R.id.fragment_tab);
        //tabFragment.goToGridView();
    }

}