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
import com.sbbi.obesityappv2.model.Prediction;
import com.sbbi.obesityappv2.model.ResponseFood;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;

import java.util.List;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter extends RecyclerView.Adapter<FoodPredictedViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private Prediction predictions;
    private List<Food> listFood;
    private List<Number> listWeight;
    private List<List<String>> listAllpredictedFood;
    private ResponseFood responseFood;
    private FoodInterf listener;
    private final int CODE = 1;
    private List<List<String>> predictionList;

    public FoodPredictionRecyclerAdapter(List<List<String>> predictionList, FoodInterf listener) {
        this.predictionList = predictionList;
        this.listener = listener;
        this.responseFood = responseFood;
        //this.inflater = LayoutInflater.from(context);
    }

    public FoodPredictionRecyclerAdapter(List<Food> listFood, List<Number> listWeight, List<List<String>> listAllpredictedFood, FoodInterf listener) {
        this.listener = listener;
        this.listFood = listFood;
        this.listWeight = listWeight;
        this.listAllpredictedFood = listAllpredictedFood;
        this.listener = listener;
    }

    public FoodPredictionRecyclerAdapter(Prediction predictions, FoodInterf listener) {
        this.predictions = predictions;
        this.listener = listener;

    }

    @Override
    public FoodPredictedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_predicted_row, parent, false);
        FoodPredictedViewHolder holder = new FoodPredictedViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(final FoodPredictedViewHolder holder, final int position) {
        /*if(position == 0){
            holder.getName().setText("Food predicted: " + responseFood.getFood1()[0]);
            holder.getWeight().setText("Weight: " + responseFood.getWeightFood1());
        }
        else if(position == 1){
            holder.getName().setText("Food predicted: " + responseFood.getFood2()[0]);
            holder.getWeight().setText("Weight: " + responseFood.getWeightFood2());
        }
        else if(position == 2){
            holder.getName().setText("Food predicted: " + responseFood.getFood3()[0]);
            holder.getWeight().setText("Weight: " + responseFood.getWeightFood3());
        }*/

        //final List<String> list = predictions.getPrediction(position);
        if(position == 0){
            holder.getName().setText(predictionList.get(0).get(0));
            holder.getOtherPredictions().setText(predictionList.get(0).get(1) + ", " + predictionList.get(0).get(2) + ", " + predictionList.get(0).get(3) + ", " + predictionList.get(0).get(4));
            holder.getPositionFood().setText("Position 3");

        }
        else if(position == 1){
            holder.getName().setText(predictionList.get(1).get(0));
            holder.getOtherPredictions().setText(predictionList.get(1).get(1) + ", " + predictionList.get(1).get(2) + ", " + predictionList.get(1).get(3) + ", " + predictionList.get(1).get(4));
            holder.getPositionFood().setText("Position 1");
        }
        else if(position == 2){
            holder.getName().setText(predictionList.get(2).get(0));
            holder.getOtherPredictions().setText(predictionList.get(2).get(1) + ", " + predictionList.get(2).get(2) + ", " + predictionList.get(2).get(3) + ", " + predictionList.get(2).get(4));
            holder.getPositionFood().setText("Position 2");
        }

        /*
        final Food current = listFood.get(position);
        holder.getName().setText("Food predicted: " + current.getName());
        holder.getWeight().setText("" + listWeight.get(position));
        */

        holder.getRemoveTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);

            }
        });

    }

    private void removeItem(int position) {

        listFood.remove(position);
        listWeight.remove(position);
        listAllpredictedFood.remove(position);

        //notifyDataSetChanged();
        notifyItemRemoved(position);//i've changed some items in the dataset, recycler, reload it

    }

    @Override
    public int getItemCount() {
        if (predictionList != null)
            return predictionList.size();
        else
            return 0;

    }

}