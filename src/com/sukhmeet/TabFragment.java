package com.sukhmeet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 03/09/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
// this class is manager of MyGrid and MyListFragment

public class TabFragment extends Fragment {
    private static final int LIST_STATE = 0x01;
    private static final int GRID_STATE = 0x02;
    private int currentState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        Button listViewButton = (Button) view.findViewById(R.id.list_view_tab);
        Button gridViewButton = (Button) view.findViewById(R.id.grid_view_tab);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListView();
            }
        });
        gridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGridView();
            }
        });
        return view;
    }

    public void goToListView(){
        System.out.println("In Go to List VIew");
        if(currentState != LIST_STATE){
            currentState = LIST_STATE;
            // Fragments have access to their parent Activity's FragmentManager. You can
            // obtain the FragmentManager like this
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            if(fragmentManager !=null){
                // Perform the FragmentTransaction to load in the list tab content.
                // Using FragmentTransaction#replace will destroy any Fragments
                // currently inside R.id.fragment_content and add the new Fragment
                // in its place.
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, new MyListFragment());
                fragmentTransaction.commit();
            }
        }
    }
    public void goToGridView(){
        System.out.println("In Go to Grid VIew");
        if(currentState != GRID_STATE){
            currentState = GRID_STATE;
            // Fragments have access to their parent Activity's FragmentManager. You can
            // obtain the FragmentManager like this
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager !=null){
                // Perform the FragmentTransaction to load in the list tab content.
                // Using FragmentTransaction#replace will destroy any Fragments
                // currently inside R.id.fragment_content and add the new Fragment
                // in its place.
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, new MyGridFragment());
                fragmentTransaction.commit();
            }
        }
    }
}
