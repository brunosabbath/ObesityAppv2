package com.sbbi.obesityappv2.recycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.holder.FoodViewHolder;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.interf.TestFoodInterf;
import com.sbbi.obesityappv2.model.Food;

import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private LayoutInflater inflater;
    private List<Food> food;
    private TestFoodInterf listener;

    public FoodRecyclerAdapter(Context context, List<Food> food, TestFoodInterf listener){
        this.listener = listener;
        this.food = food;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.food_row, parent, false);
        FoodViewHolder holder = new FoodViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        final Food current = food.get(position);

        holder.getName().setText(current.getName());
    }

    @Override
    public int getItemCount() {
        if(food != null)
            return food.size();
        else
            return 0;
    }
}
