package com.sukhmeet;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 04/09/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactsContentProviderActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        TextView contactView = (TextView)findViewById(R.id.contactview);
        Cursor cursor = getContacts();
        while(cursor.moveToNext()){
            String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
            contactView.append("Name : ");
            contactView.append(displayName);
            contactView.append("\n");
        }
    }

    private Cursor getContacts() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String [] allContacts = new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME};
        return getContentResolver().query(uri,allContacts,null, null,null,null);
    }
}