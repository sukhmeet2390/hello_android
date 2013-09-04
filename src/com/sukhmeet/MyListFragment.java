package com.sukhmeet;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 03/09/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyListFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        System.out.println("Step 2");

        Activity activity = getActivity();
        if(activity != null){
            // get the data which u want to show
            TextView textView  = new TextView(activity);
            textView.setText("This is my List fragment");
        }
    }
}
