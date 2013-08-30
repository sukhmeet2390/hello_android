package com.sukhmeet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 29/08/13
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayMessageActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        // Create Text View
        TextView textView = new TextView(this);
        textView.setText(message);

        // set the text view as activity layout
        setContentView(textView);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}