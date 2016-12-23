package com.sbbi.obesityappv2.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.interf.TestFoodInterf;

/**
 * Created by bsilva on 10/18/16.
 */
public class FoodViewHolder extends RecyclerView.ViewHolder{

    private TextView name;
    private View itemView;
    private TestFoodInterf listener;

    public FoodViewHolder(View itemView, final TestFoodInterf listener) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name);
    }

    public TextView getName(){
        return name;
    }


}
