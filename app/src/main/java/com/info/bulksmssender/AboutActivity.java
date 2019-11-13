package com.info.bulksmssender;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.info.bulksmssender.api.APIClient;
import com.info.bulksmssender.model.APIResponse;
import com.info.bulksmssender.model.ContactNumber;
import com.info.bulksmssender.model.ProductResponse;
import com.info.bulksmssender.model.Unit;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutActivity extends AppCompatActivity {
    HashMap<String, Integer> categoryMap = new HashMap<>();
    ArrayList<Unit> productResponses = new ArrayList<Unit>();
    int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);


        categoryMap.put("GroceryStaples", 18);
        categoryMap.put("CakesFlowers", 603);
        categoryMap.put("FruitsVegetables", 30);
        categoryMap.put("HouseHold", 34);
        categoryMap.put("Beverages", 29);
        categoryMap.put("PersonalCare", 27);
        categoryMap.put("DairyBread", 25);
        categoryMap.put("BrandedFoods", 17);
        getData();
    }

    public void getData() {

        Call<ProductResponse> call = APIClient.getAPIInterface().getProducts("", 18, page);
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.body().isSuccess()) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        productResponses.addAll(response.body().getData().get(i).getUnit());
                    }
                    page++;
                    getData();
                }else{

                    Gson gson=new Gson();
                    String data=gson.toJson(productResponses);
                    Log.v("response",data+" ");
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Gson gson=new Gson();
                String data=gson.toJson(productResponses);
                Log.v("response",data+" ");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return true;
    }
}
