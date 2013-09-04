package com.sukhmeet;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 03/09/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyGridFragment extends Fragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if(activity != null){
            // get the data which u want to show
            TextView textView  = new TextView(activity);
            textView.setText("This is my Grid fragment");
        }
    }
}
