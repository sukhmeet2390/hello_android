package com.sukhmeet;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 03/09/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // onCreateView() is a lifecycle event that is unique to a Fragment. This is called when Android
        // needs the layout for this Fragment.
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        // The call to LayoutInflater::inflate() simply takes the layout
        // ID for the layout file, the parent view that will hold the layout, and an option to add the inflated
        // view to the parent. This should always be false or an exception will be thrown. Android will add
        // the view to the parent when necessary.
        Button button = (Button)view.findViewById(R.id.fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity!=null){
                    System.out.println("This activity is not null");
                }

            }
        });
        return view;
    }


}
