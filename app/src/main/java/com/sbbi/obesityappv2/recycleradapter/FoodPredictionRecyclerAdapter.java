package com.sbbi.obesityappv2.recycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.holder.FoodPredictedViewHolder;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter extends RecyclerView.Adapter<FoodPredictedViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private Food[] food;
    private FoodInterf listener;

    public FoodPredictionRecyclerAdapter(Food[] food, FoodInterf listener) {
        this.listener = listener;
        this.food = food;
        //this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FoodPredictedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_predicted_row, parent, false);
        FoodPredictedViewHolder holder = new FoodPredictedViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoodPredictedViewHolder holder, int position) {
        final Food current = food[position];

        holder.getName().setText("Food predicted: " + current.getName());
    }

    @Override
    public int getItemCount() {
        if (food != null)
            return food.length;
        else
            return 0;
    }

}