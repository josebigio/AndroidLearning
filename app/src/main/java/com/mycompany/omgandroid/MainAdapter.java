package com.mycompany.omgandroid;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by josebigio on 4/22/15.
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "MainAdapter";

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }



    public static final int TOP_FRAGMENT_TYPE = 0;
    public static final int BOTTOM_FRAGMENT_TYPE = 1;




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Log.v(TAG, "OnCreateViewHolder(" + viewGroup + ", " + i);
        View v;
        switch (i) {
            case TOP_FRAGMENT_TYPE:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transit_fragment_rename,viewGroup,false);
                return new ViewHolder(v);
            case BOTTOM_FRAGMENT_TYPE:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bottom_fragment,viewGroup,false);
                return new ViewHolder(v);
            default:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bottom_fragment,viewGroup,false);
                return new ViewHolder(v);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        Log.v(TAG, "getItemViewType(" + position + ")");
        switch (position) {
            case 0:
                return TOP_FRAGMENT_TYPE;
            case 1:
                return BOTTOM_FRAGMENT_TYPE;
           default:
               return BOTTOM_FRAGMENT_TYPE;
        }
    }




}
