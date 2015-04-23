package com.mycompany.omgandroid;


import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class Home extends ActionBarActivity implements View.OnClickListener {

    View layoutView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        layoutView = (View)findViewById(R.id.main_activity_layout);

        setUpViews();

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
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);



//        Fragment_Transit transitFragment = new Fragment_Transit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, transitFragment).commit();



    }
}
