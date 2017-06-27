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
    private TextView otherPredictedFood;
    private TextView listButton;
    private TextView removeButton;
    private TextView positionFood;
    private View itemView;
    private FoodInterf listener;

    public FoodPredictedViewHolder(final View itemView, final FoodInterf listener) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name);
        removeButton = (TextView) itemView.findViewById(R.id.remove_food);
        otherPredictedFood = (TextView) itemView.findViewById(R.id.other_predicted);
        positionFood = (TextView) itemView.findViewById(R.id.position_food);

    }

    public Context getContext(){
        return itemView.getContext();
    }

    public TextView getPositionFood(){
        return positionFood;
    }

    public TextView getOtherPredictions(){
        return otherPredictedFood;
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
