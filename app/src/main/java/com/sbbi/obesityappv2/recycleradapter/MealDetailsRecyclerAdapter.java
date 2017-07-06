package com.sbbi.obesityappv2.recycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.holder.FoodDetailsViewHolder;
import com.sbbi.obesityappv2.model.pojo.FoodPojo;

import java.util.List;

/**
 * Created by bsilva on 5/31/17.
 */

public class MealDetailsRecyclerAdapter extends RecyclerView.Adapter<FoodDetailsViewHolder>{

    private List<FoodPojo> listFood;
    private Context mContext;

    public MealDetailsRecyclerAdapter(Context context, List<FoodPojo> listFood){
        this.listFood = listFood;
        this.mContext = context;
    }


    @Override
    public FoodDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_detail_row, null);
        FoodDetailsViewHolder viewHolder = new FoodDetailsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodDetailsViewHolder holder, int position) {
        final FoodPojo food = listFood.get(position);

        holder.getNameFood().setText(food.getName());
        holder.getCarbohydrateFood().setText("Carbohydrate: " + food.getCarbohydrate() + " g");
        holder.getEnergyFood().setText("Energy: " + food.getEnergy() + " kcal");
        holder.getFiberFood().setText("Fiber: " + food.getFiber() + " g");
        holder.getLipidFood().setText("Lipids: " + food.getLipid() + " g");
        holder.getProteinFood().setText("Protein: " + food.getProtein() + " g");
        holder.getSugarFood().setText("Sugar: " + food.getSugar() + " g");
        holder.getGramFood().setText("Grams: " + food.getGrams() + " g");
        holder.getCholesterol().setText("Cholesterol: " + food.getCholesterol() + " g");

    }

    @Override
    public int getItemCount() {
        if(listFood != null)
            return listFood.size();
        else
            return 0;
    }
}
