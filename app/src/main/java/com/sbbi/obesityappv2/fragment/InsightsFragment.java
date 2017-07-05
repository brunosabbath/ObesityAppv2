package com.sbbi.obesityappv2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fitbit.api.ResourceLoadedHandler;
import com.fitbit.api.models.ActivitiesCalories;
import com.fitbit.api.models.User;
import com.fitbit.api.services.CaloriesService;
import com.fitbit.api.services.UserService;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.InsightActivity;
import com.sbbi.obesityappv2.helper.ConnectionHelper;
import com.sbbi.obesityappv2.helper.GetUserIdHelper;

import java.util.ArrayList;
import java.util.List;

public class InsightsFragment extends Fragment implements UserService.UserHandler, ResourceLoadedHandler, View.OnClickListener{

    private int caloriesBurned = 0;
    private List<String> insights;

    public InsightsFragment() {
        insights = new ArrayList<String>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_insights, container, false);

        Button insightBtn = (Button) view.findViewById(R.id.insight_button);
        insightBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.insight_button){

            if(ConnectionHelper.isInternetAvailable(getContext())){
                buttonClick();
            }
            else{
                Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_LONG).show();
            }

        }

        /*switch(v.getId()){
            case R.id.insight_button:
                buttonClick();
                break;
        }*/
    }

    private void buttonClick() {

        CaloriesService.getUserCaloriesToday(getActivity(), new CaloriesService.CalorieHandler(){

            @Override
            public void onCalorieLoaded(List<ActivitiesCalories> container) {

                if(container.size() > 0) {
                    caloriesBurned = Integer.parseInt(container.get(0).getValue());
                }
                else{
                    caloriesBurned = 1750;
                }

                int userId = GetUserIdHelper.getUserId(getContext());

                Intent intent = new Intent(getActivity(), InsightActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("caloriesBurned", caloriesBurned);
                extras.putInt("userId",userId);
                intent.putExtras(extras);
                startActivity(intent);

                //new InsightHttp(this).execute(userId, caloriesBurned);
                //new InsightHttp(m).execute(userId, caloriesBurned);
                //make api call
                //get result
                //save bundle and send it to another activity
            }

            @Override
            public void onErrorLoadingCalorie(String errorMessage) {
                Toast.makeText(getActivity(), "Please go to Preferences tab and click on Fitbit button", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onResourceLoaded(Object resource) {

    }

    @Override
    public void onResourceLoadError(String errorMessage) {

    }

    @Override
    public void onUserLoaded(User user) {

    }

    @Override
    public void onErrorLoadingUser(String errorMessage) {

    }
}