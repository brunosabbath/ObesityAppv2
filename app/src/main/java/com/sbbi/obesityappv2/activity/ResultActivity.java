package com.sbbi.obesityappv2.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.helper.ConnectionHelper;
import com.sbbi.obesityappv2.helper.GetUserIdHelper;
import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.interf.RedirectListener;
import com.sbbi.obesityappv2.interf.SavedMealListener;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.FoodsWeightEstimation;
import com.sbbi.obesityappv2.model.Prediction;
import com.sbbi.obesityappv2.model.ResponseFood;
import com.sbbi.obesityappv2.model.SendMeal;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.recycleradapter.FoodPredictionRecyclerAdapter;
import com.sbbi.obesityappv2.request.HttpSaveMeal;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classification results
 *
 *
 */
public class ResultActivity extends AppCompatActivity implements SavedMealListener {

    private RecyclerView recyclerView;
    private FoodPredictionRecyclerAdapter foodAdapter;
    private final int CODE = 1;
    private final int TOTAL_FOOD = 13;
    private List<Food> listFood;
    private List<Number> listWeight;
    private List<String> listpredictedFood1;
    private List<String> listpredictedFood2;
    private List<String> listpredictedFood3;
    private List<List<String>> listAllpredictedFood;
    private Prediction predictions;
    private ProgressDialog progressDialog;
    private int typeMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);//new layout with CardView

        Bundle extras = getIntent().getExtras();

        //get predictions from previous activity
        predictions = (Prediction) extras.get("result");

        //get meal type
        this.typeMeal = (int) extras.getInt("typeMeal");
        predictions.setTypeMeal(this.typeMeal);

        recyclerView = (RecyclerView) findViewById(R.id.foodPrediction);

        //send data to adapter
        List<List<String>> list = new ArrayList<>();
        list.add(predictions.getPredictionsFoodLeft());
        list.add(predictions.getPredictionsFoodRight());
        list.add(predictions.getPredictionsFoodBottom());

        foodAdapter = new FoodPredictionRecyclerAdapter(list);
        recyclerView.setAdapter(foodAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.result_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save_meal:
                String predictionsString[] = foodAdapter.getTextPredictions();
                saveMeal(predictionsString);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveMeal(String predictionsString[]){

        //make predictions correct
        predictions.updatePredictionLeft(predictionsString[0]);
        predictions.updatePredictionRight(predictionsString[1]);
        predictions.updatePredictionBottom(predictionsString[2]);

        int userId = GetUserIdHelper.getUserId(getApplicationContext());

        if(ConnectionHelper.isInternetAvailable(getApplicationContext())){
            showProgressDialog();
            new HttpSaveMeal(this, userId, predictions).execute();
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet connectivity", Toast.LENGTH_LONG).show();
        }

    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(ResultActivity.this);
        progressDialog.setTitle("Saving meal");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void cancelProgressDialog() {
        progressDialog.cancel();
    }


    public int getUserId() {
        ObesityDbDao dao = new ObesityDbDao(this);
        User user = dao.getUser();
        return user.getId();
    }

    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1 == 1)
                Toast.makeText(getApplicationContext(),"Meal has been added", Toast.LENGTH_SHORT).show();
            else if(msg.arg1 == 1)
                Toast.makeText(getApplicationContext(),"Error to save meal", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void sendToResultScreen(FoodsWeightEstimation foodsWeightEstimation) {

        Intent intent = new Intent(this, ResultNutrientActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", foodsWeightEstimation);
        intent.putExtras(bundle);
        cancelProgressDialog();
        startActivity(intent);

    }
}