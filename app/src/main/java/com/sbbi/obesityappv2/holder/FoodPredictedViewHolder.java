package com.sbbi.obesityappv2.holder;

import android.content.Context;
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
    private TextView removeButton;
    private View itemView;
    private FoodInterf listener;

    public FoodPredictedViewHolder(final View itemView, final FoodInterf listener) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name);
        correctButton = (TextView) itemView.findViewById(R.id.correct_prediction);
        listButton = (TextView) itemView.findViewById(R.id.list_nutrients);
        removeButton = (TextView) itemView.findViewById(R.id.remove_food);

    }

    public Context getContext(){
        return itemView.getContext();
    }

    public TextView getPredictedClassesTextView(){
        return correctButton;
    }

    public TextView getListNutrientsTextView(){
        return listButton;
    }

    public TextView getRemoveTextView(){
        return removeButton;
    }

    public TextView getName(){
        return name;
    }

}
