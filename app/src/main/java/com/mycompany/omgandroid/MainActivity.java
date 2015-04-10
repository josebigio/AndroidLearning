package com.mycompany.omgandroid;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    ShareActionProvider mShareActionProvider;
    Button changeActivityButton;

    final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView)findViewById(R.id.main_textview);
        mainTextView.setText("Changed programatically");

        mainButton = (Button)findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mainEditText = (EditText)findViewById(R.id.main_edit_text);

        // 4. Access the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);
        mainListView.setOnItemClickListener(this);

        changeActivityButton = (Button)findViewById(R.id.next_activity_button);
        changeActivityButton.setOnClickListener(this);


        Toast.makeText(this,"Hello!!!!",Toast.LENGTH_LONG).show();

// Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

// Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);

    }

    @Override
    public void onClick(View v) {

        if(v == changeActivityButton) {
            Toast.makeText(this,"You clicked the change activity button",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity2Activity.class);
            intent.putExtra(EXTRA_MESSAGE,"this is the extra message");
            startActivity(intent);
        }
        else{
            mainTextView.setText(mainEditText.getText());
            mNameList.add(mainTextView.getText().toString());
            mArrayAdapter.notifyDataSetChanged();
            setShareIntent();
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android","clicked item number: " + position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu.
        // Adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Access the Share Item defined in menu XML
        MenuItem shareItem = menu.findItem(R.id.menu_item_share);

        // Access the object responsible for
        // putting together the sharing submenu
        if (shareItem != null) {
            mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        }

        // Create an Intent to share your content
        setShareIntent();

        return true;
    }

    private void setShareIntent() {

        if (mShareActionProvider != null) {

            // create an Intent with the contents of the TextView
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Development");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainTextView.getText());

            // Make sure the provider knows
            // it should work with that Intent
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }


}
