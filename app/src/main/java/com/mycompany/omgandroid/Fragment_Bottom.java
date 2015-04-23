package com.mycompany.omgandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/**
 * Created by josebigio on 4/22/15.
 */
public class Fragment_Bottom extends Fragment {



    View mainLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        mainLayout = inflater.inflate(R.layout.bottom_fragment,container,false);
        setupViews();
        return mainLayout;
    }


    public void setupViews(){


    }










}
