package com.sbbi.obesityappv2.recycleradapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.ResultActivity;
import com.sbbi.obesityappv2.holder.FoodViewHolder;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter  extends RecyclerView.Adapter<FoodViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private Food[] food;
    private FoodInterf listener;

    public FoodPredictionRecyclerAdapter(Food[] food, FoodInterf listener) {
        this.listener = listener;
        this.food = food;
        //this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_predicted_row, parent, false);
        FoodViewHolder holder = new FoodViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        final Food current = food[position];

        holder.getName().setText(current.getName());
    }

    @Override
    public int getItemCount() {
        if (food != null)
            return food.length;
        else
            return 0;
    }

}