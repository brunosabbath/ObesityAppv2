package com.sbbi.obesityappv2.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.FoodInterf;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictedViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView correctButton;
    private TextView listButton;
    private View itemView;
    private FoodInterf listener;

    public FoodPredictedViewHolder(View itemView, final FoodInterf listener) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name);
        correctButton = (TextView) itemView.findViewById(R.id.correct_prediction);
        listButton = (TextView) itemView.findViewById(R.id.list_nutrients);

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OI","correct clicked");
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ERROR","list button");
            }
        });

    }

    public TextView getName(){
        return name;
    }

}
