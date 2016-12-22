package com.sbbi.obesityappv2.recycleradapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.CorrectPrediction;
import com.sbbi.obesityappv2.activity.ListNutrients;
import com.sbbi.obesityappv2.activity.ResultActivity;
import com.sbbi.obesityappv2.holder.FoodPredictedViewHolder;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;

import java.util.List;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter extends RecyclerView.Adapter<FoodPredictedViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private List<Food> food;
    private FoodInterf listener;
    private final int CODE = 1;

    public FoodPredictionRecyclerAdapter(List<Food> food, FoodInterf listener) {
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
    public void onBindViewHolder(final FoodPredictedViewHolder holder, final int position) {
        final Food current = food.get(position);

        holder.getName().setText("Food predicted: " + current.getName());

        holder.getRemoveTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);

            }
        });

        holder.getListNutrientsTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.getContext(), ListNutrients.class);
                holder.getContext().startActivity(intent);
            }
        });

        holder.getPredictedClassesTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.getContext(), CorrectPrediction.class);
                //((Activity)holder.getContext()).startActivityForResult(intent, CODE);

                Bundle bundle = new Bundle();
                BundleCorrectFood myBundle = new BundleCorrectFood();
                myBundle.setPosition(position);

                intent.putExtra("myBundle", myBundle);

                ((ResultActivity)holder.getContext()).startCorretPredictionActivity(intent);
                //activityListener.onActivityResultMethod();
            }
        });

    }

    private void removeItem(int position) {

        food.remove(position);
        //notifyDataSetChanged();
        notifyItemRemoved(position);//i've changed some items in the dataset, recycler, reload it

    }

    @Override
    public int getItemCount() {
        if (food != null)
            return food.size();
        else
            return 0;
    }

}