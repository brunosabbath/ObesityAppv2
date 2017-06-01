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
import com.sbbi.obesityappv2.model.ResponseFood;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;

import java.util.List;

/**
 * Created by bsilva on 12/21/16.
 */

public class FoodPredictionRecyclerAdapter extends RecyclerView.Adapter<FoodPredictedViewHolder>{

    //extends RecyclerView.Adapter<FoodViewHolder>
    private List<Food> listFood;
    private List<Number> listWeight;
    private List<List<String>> listAllpredictedFood;
    private ResponseFood responseFood;
    private FoodInterf listener;
    private final int CODE = 1;

    /*public FoodPredictionRecyclerAdapter(List<Food> food, FoodInterf listener) {
        this.listener = listener;
        this.food = food;
        //this.inflater = LayoutInflater.from(context);
    }*/

    //public FoodPredictionRecyclerAdapter(ResponseFood responseFood, FoodInterf listener) {
    public FoodPredictionRecyclerAdapter(List<Food> food, FoodInterf listener) {
        this.listener = listener;
        this.listFood = food;
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

    @Override
    public FoodPredictedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_predicted_row, parent, false);
        FoodPredictedViewHolder holder = new FoodPredictedViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(final FoodPredictedViewHolder holder, final int position) {
        final Food current = listFood.get(position);

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

        holder.getName().setText("Food predicted: " + current.getName());
        holder.getWeight().setText("" + listWeight.get(position));


        holder.getRemoveTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);

            }
        });



        holder.getListNutrientsTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle extras = new Bundle();
                extras.putSerializable("food", listFood.get(position));

                Intent intent = new Intent(holder.getContext(), ListNutrients.class);
                intent.putExtras(extras);

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

        /*if(position == 0){
            responseFood.setWeightFood1(0);
            responseFood.setFood1(null);
            responseFood.setNutrientsFood1(null);

        }
        else if(position == 1){
            responseFood.setWeightFood2(0);
            responseFood.setFood2(null);
            responseFood.setNutrientsFood2(null);
        }
        else if(position == 2){
            responseFood.setWeightFood3(0);
            responseFood.setFood3(null);
            responseFood.setNutrientsFood3(null);
        }*/

        listFood.remove(position);
        listWeight.remove(position);
        listAllpredictedFood.remove(position);

        //notifyDataSetChanged();
        notifyItemRemoved(position);//i've changed some items in the dataset, recycler, reload it

    }

    @Override
    public int getItemCount() {
        if (listFood != null)
            return listFood.size();
        else
            return 0;
    }

}