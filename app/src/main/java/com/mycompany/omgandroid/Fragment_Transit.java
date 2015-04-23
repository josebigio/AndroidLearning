package com.mycompany.omgandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


public class Fragment_Transit extends Fragment {

    View mainLayout;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        mainLayout = inflater.inflate(R.layout.transit_fragment_rename,container,false);
        setupViews();
        return mainLayout;
    }


    public void setupViews(){

        ViewTreeObserver vto = mainLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                View circleViewParent = (View)mainLayout.findViewById(R.id.circle_view_parent);
                circleViewParent.getLayoutParams().width = circleViewParent.getMeasuredHeight();
                mainLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }


}
