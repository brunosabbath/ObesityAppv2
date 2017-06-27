package com.sbbi.obesityappv2.recycleradapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private Prediction predictions;
    private List<Food> listFood;
    private List<Number> listWeight;
    private List<List<String>> listAllpredictedFood;
    private List<List<String>> predictionList;
    private String[] predictionsString;

    public FoodPredictionRecyclerAdapter(List<List<String>> predictionList) {
        this.predictionList = predictionList;
        predictionsString = new String[3];
    }

    @Override
    public FoodPredictedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_predicted_row, parent, false);
        FoodPredictedViewHolder holder = new FoodPredictedViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final FoodPredictedViewHolder holder, final int position) {

        if(position == 0){
            holder.getName().setText(predictionList.get(0).get(0));
            //holder.getOtherPredictions().setText(predictionList.get(0).get(1) + ", " + predictionList.get(0).get(2) + ", " + predictionList.get(0).get(3) + ", " + predictionList.get(0).get(4));
            holder.getButtonPrediction(2).setText(predictionList.get(0).get(1));
            holder.getButtonPrediction(3).setText(predictionList.get(0).get(2));
            holder.getButtonPrediction(4).setText(predictionList.get(0).get(3));
            holder.getButtonPrediction(5).setText(predictionList.get(0).get(4));
            holder.getPositionFood().setText("Position 1");
            predictionsString[0] = predictionList.get(0).get(0);
        }
        else if(position == 1){
            holder.getName().setText(predictionList.get(1).get(0));
            //holder.getOtherPredictions().setText(predictionList.get(1).get(1) + ", " + predictionList.get(1).get(2) + ", " + predictionList.get(1).get(3) + ", " + predictionList.get(1).get(4));
            holder.getButtonPrediction(2).setText(predictionList.get(1).get(1));
            holder.getButtonPrediction(3).setText(predictionList.get(1).get(2));
            holder.getButtonPrediction(4).setText(predictionList.get(1).get(3));
            holder.getButtonPrediction(5).setText(predictionList.get(1).get(4));
            holder.getPositionFood().setText("Position 2");
            predictionsString[1] = predictionList.get(1).get(0);
        }
        else if(position == 2){
            holder.getName().setText(predictionList.get(2).get(0));
            //holder.getOtherPredictions().setText(predictionList.get(2).get(1) + ", " + predictionList.get(2).get(2) + ", " + predictionList.get(2).get(3) + ", " + predictionList.get(2).get(4));
            holder.getButtonPrediction(2).setText(predictionList.get(2).get(1));
            holder.getButtonPrediction(3).setText(predictionList.get(2).get(2));
            holder.getButtonPrediction(4).setText(predictionList.get(2).get(3));
            holder.getButtonPrediction(5).setText(predictionList.get(2).get(4));
            holder.getPositionFood().setText("Position 3");
            predictionsString[2] = predictionList.get(2).get(0);
        }

        holder.getButtonPrediction(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText(v, holder.getButtonPrediction(2), holder.getName());
                predictionsString[position] = holder.getName().getText().toString();
            }
        });

        holder.getButtonPrediction(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText(v, holder.getButtonPrediction(3), holder.getName());
                predictionsString[position] = holder.getName().getText().toString();
            }
        });

        holder.getButtonPrediction(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText(v, holder.getButtonPrediction(4), holder.getName());
                predictionsString[position] = holder.getName().getText().toString();
            }
        });

        holder.getButtonPrediction(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText(v, holder.getButtonPrediction(5), holder.getName());
                predictionsString[position] = holder.getName().getText().toString();
            }
        });

        holder.getRemoveTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });

    }

    private void changeText(View v, Button buttonPrediction, TextView textView) {
        String auxName = textView.getText().toString();
        textView.setText(buttonPrediction.getText().toString());
        buttonPrediction.setText(auxName);
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

    public String[] getTextPredictions() {
        return predictionsString;
    }
}