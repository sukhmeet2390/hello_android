package com.sukhmeet;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 04/09/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDatabaseActivity extends ListActivity {
    private AndroidDataSource dataSource;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);
        dataSource = new AndroidDataSource(this);
        dataSource.open();
        List<Comment> values = dataSource.getAllComments();

        //http://stackoverflow.com/questions/3663745/what-is-android-r-layout-simple-list-item-1
        //http://developer.android.com/reference/android/R.layout.html
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    public void onClick(View view) {
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;
        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[]{"Cool", "Very nice", "Good Job", "Lovely", "Love u"};
                int nextInt = new Random().nextInt(5);
                comment = dataSource.insertComment(comments[nextInt]);
                adapter.add(comment);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    dataSource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged(); // to refresh the views that are listening to it
    }
    @Override
    protected void onResume(){
        dataSource.open();
        super.onResume();
    }
    @Override
    protected void onPause(){
        dataSource.close();
        super.onPause();

    }
}