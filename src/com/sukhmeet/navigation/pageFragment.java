package com.sukhmeet.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sukhmeet.R;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 10/09/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class pageFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    public pageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
}
