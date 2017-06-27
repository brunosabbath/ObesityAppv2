package com.sbbi.obesityappv2.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button buttonPrediction2;
    private Button buttonPrediction3;
    private Button buttonPrediction4;
    private Button buttonPrediction5;


    public FoodPredictedViewHolder(final View itemView) {
        super(itemView);
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name);
        removeButton = (TextView) itemView.findViewById(R.id.remove_food);
        positionFood = (TextView) itemView.findViewById(R.id.position_food);
        buttonPrediction2 = (Button) itemView.findViewById(R.id.btn_predicted_2);
        buttonPrediction3 = (Button) itemView.findViewById(R.id.btn_predicted_3);
        buttonPrediction4 = (Button) itemView.findViewById(R.id.btn_predicted_4);
        buttonPrediction5 = (Button) itemView.findViewById(R.id.btn_predicted_5);
    }

    public Context getContext(){
        return itemView.getContext();
    }

    public TextView getPositionFood(){
        return positionFood;
    }

    public Button getButtonPrediction(int id){
        if(id == 2)
            return buttonPrediction2;
        else if(id == 3)
            return buttonPrediction3;
        else if(id == 4)
            return buttonPrediction4;
        else
            return buttonPrediction5;
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
