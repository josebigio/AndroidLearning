package com.mycompany.omgandroid;


import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Home extends ActionBarActivity implements View.OnClickListener {

    View layoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        layoutView = (View)findViewById(R.id.main_activity_layout);
        setUpViews();






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupActionBar(int res) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        if (actionBar != null) {
            actionBar.setCustomView(res);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setIcon(
                    new ColorDrawable(getResources().getColor(
                            android.R.color.transparent))
            );
            View view = actionBar.getCustomView();


        }
    }

    @Override
    public void onClick(View v) {

    }

    public void setUpViews() {
        setupActionBar(R.layout.action_bar);

        Fragment_Transit transitFragment = new Fragment_Transit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, transitFragment).commit();



    }
}
