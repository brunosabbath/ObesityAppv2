package com.sbbi.obesityappv2.recycleradapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.CorrectPrediction;
import com.sbbi.obesityappv2.activity.MealDetailsActivity;
import com.sbbi.obesityappv2.holder.FoodViewHolder;
import com.sbbi.obesityappv2.holder.MealViewHolder;
import com.sbbi.obesityappv2.interf.MealPojoListener;
import com.sbbi.obesityappv2.interf.TestFoodInterf;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;
import com.sbbi.obesityappv2.model.pojo.MealPojo;

import java.util.List;

/**
 * Created by bsilva on 3/10/17.
 */

public class MealRecyclerAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private LayoutInflater inflater;
    private List<MealPojo> meals;
    private MealPojoListener listener;

    public MealRecyclerAdapter(Context context, List<MealPojo> meals, MealPojoListener listener){
        this.listener = listener;
        this.meals = meals;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_row, parent, false);
        MealViewHolder holder = new MealViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MealViewHolder holder, final int position) {

        final MealPojo mealPojo = meals.get(position);

        holder.getMealType().setText(mealPojo.getType());

        holder.getMealType().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(holder.getContext(), "item " + position + " clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(holder.getContext(), MealDetailsActivity.class);
                //((Activity)holder.getContext()).startActivityForResult(intent, CODE);

                Bundle bundle = new Bundle();
                intent.putExtra("mealPojo", mealPojo);
                holder.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(meals != null)
            return meals.size();
        else
            return 0;
    }
}
