package com.sbbi.obesityappv2.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;

/**
 * Created by bsilva on 3/10/17.
 */

public class FoodDetailsViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private TextView name;
    private TextView carbohydrate;
    private TextView energy;
    private TextView fiber;
    private TextView lipid;
    private TextView protein;
    private TextView sugar;
    private TextView gram;

    public FoodDetailsViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;

        name = (TextView) itemView.findViewById(R.id.food_name_detail);
        carbohydrate = (TextView) itemView.findViewById(R.id.food_carbohydrate_detail);
        energy = (TextView) itemView.findViewById(R.id.food_energy_detail);
        fiber = (TextView) itemView.findViewById(R.id.food_fiber_detail);
        lipid = (TextView) itemView.findViewById(R.id.food_lipid_detail);
        protein = (TextView) itemView.findViewById(R.id.food_protein_detail);
        sugar = (TextView) itemView.findViewById(R.id.food_sugar_detail);
        gram = (TextView) itemView.findViewById(R.id.food_grams_detail);

    }

    public TextView getNameFood(){return name;}
    public TextView getCarbohydrateFood(){return carbohydrate;}
    public TextView getEnergyFood(){return energy;}
    public TextView getFiberFood(){return fiber;}
    public TextView getLipidFood(){return lipid;}
    public TextView getProteinFood(){return protein;}
    public TextView getSugarFood(){return sugar;}
    public TextView getGramFood(){return gram;}

}
