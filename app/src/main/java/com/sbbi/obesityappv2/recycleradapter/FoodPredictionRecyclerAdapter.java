package com.sbbi.obesityappv2.recycleradapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.CorrectPrediction;
import com.sbbi.obesityappv2.activity.ListNutrients;
import com.sbbi.obesityappv2.holder.FoodPredictedViewHolder;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;

import java.util.List;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter extends RecyclerView.Adapter<FoodPredictedViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private List<Food> food;
    private FoodInterf listener;

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

        Log.i("WARNING", "POSITION: " + position);

        holder.getName().setText("Food predicted: " + current.getName());

        holder.getRemoveTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("PORRA", "deleting item " + position);
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
                holder.getContext().startActivity(intent);
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