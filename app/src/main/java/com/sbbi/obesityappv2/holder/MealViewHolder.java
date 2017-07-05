package com.sbbi.obesityappv2.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.MealPojoListener;
import com.sbbi.obesityappv2.interf.TestFoodInterf;

/**
 * Created by bsilva on 3/10/17.
 */

public class MealViewHolder extends RecyclerView.ViewHolder{

    private TextView mealType;
    private TextView mealDate;
    private View itemView;
    private MealPojoListener listener;

    public MealViewHolder(View itemView, final MealPojoListener listener) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;

        mealType = (TextView) itemView.findViewById(R.id.meal_type);
        mealDate = (TextView) itemView.findViewById(R.id.meal_date);

    }

    public TextView getMealType(){
        return mealType;
    }

    public TextView getMealDate(){
        return mealDate;
    }

    public Context getContext() {
        return itemView.getContext();

    }
}
