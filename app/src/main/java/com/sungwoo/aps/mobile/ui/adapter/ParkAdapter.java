package com.sungwoo.aps.mobile.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sungwoo.aps.mobile.R;
import com.sungwoo.aps.mobile.ui.view.PartialParkingView;

/**
 * Ikorn Solutions Co.,Ltd ... on 19-Aug-17.
 * All rights reserved
 */

public class ParkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_partial_parking, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PartialParkingView vh = new PartialParkingView(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
