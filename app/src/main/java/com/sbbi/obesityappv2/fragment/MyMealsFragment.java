package com.sbbi.obesityappv2.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.CameraActivity;
import com.sbbi.obesityappv2.activity.PhotoMenuActivity;
import com.sbbi.obesityappv2.helper.ConnectionHelper;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.interf.MealPojoListener;
import com.sbbi.obesityappv2.interf.TestFoodInterf;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.model.pojo.MealPojo;
import com.sbbi.obesityappv2.recycleradapter.FoodRecyclerAdapter;
import com.sbbi.obesityappv2.recycleradapter.MealRecyclerAdapter;
import com.sbbi.obesityappv2.request.HttpListMealUser;
import com.sbbi.obesityappv2.request.HttpRequestListFood;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bsilva on 10/18/16.
 */
public class MyMealsFragment extends Fragment implements MealPojoListener{

    //private FoodRecyclerAdapter foodAdapter;
    private MealRecyclerAdapter mealAdapter;
    private RecyclerView recyclerView;
    private FoodInterf listener;
    private FloatingActionButton button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_my_meals, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_food);

        //foodAdapter = new FoodRecyclerAdapter(getActivity(), new ArrayList<Food>(), this);
        mealAdapter = new MealRecyclerAdapter(getActivity(), new ArrayList<MealPojo>(), this);

        recyclerView.setAdapter(mealAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //floating button
        button = (FloatingActionButton) layout.findViewById(R.id.buttonPlus);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String typeMeals[] = new String[] {"Breakfast", "Lunch", "Dinner", "Snack"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select meal");
                builder.setItems(typeMeals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //detabase starts with breakfast at position 1
                        which = which + 1;

                        Intent intent = new Intent(getActivity(), PhotoMenuActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("typeMeal", which);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });

        List<Food> listFood = new ArrayList<Food>();

        if(ConnectionHelper.isInternetAvailable(getContext())){

            int userId = getUserId();
            new HttpListMealUser(this).execute(userId);
        }
        else{
            Toast.makeText(getContext(), "No internet connectivity", Toast.LENGTH_LONG).show();
        }

        //setLayoutAfterRequest(listFood);
        //new HttpRequestListFood(this).execute();

        return layout;
    }


    public int getUserId() {
        ObesityDbDao dao = new ObesityDbDao(getContext());
        User user = dao.getUser();
        return user.getId();
    }

    @Override
    public void setLayoutAfterRequest(List<MealPojo> listMeal) {
        if(listMeal.size() == 0) {
            //Toast.makeText(getActivity(),Path.NO_EVENTS_FOUND,Toast.LENGTH_LONG).show();
            //errorMsg.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "No meals have been found", Toast.LENGTH_LONG).show();
        }
        else{
            //errorMsg.setVisibility(View.INVISIBLE);
            mealAdapter = new MealRecyclerAdapter(getActivity(), listMeal, this);
            recyclerView.setAdapter(mealAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    /*@Override
    public void setLayoutAfterRequest(List<Food> food) {
        if(food.size() == 0) {
            //Toast.makeText(getActivity(),Path.NO_EVENTS_FOUND,Toast.LENGTH_LONG).show();
            //errorMsg.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "No meals have been found", Toast.LENGTH_LONG).show();
        }
        else{
            //errorMsg.setVisibility(View.INVISIBLE);
            foodAdapter = new FoodRecyclerAdapter(getActivity(), food, this);
            recyclerView.setAdapter(foodAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }*/

}