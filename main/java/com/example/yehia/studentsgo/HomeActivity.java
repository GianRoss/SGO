package com.example.yehia.studentsgo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;
import com.example.yehia.studentsgo.service.AsyncTaskTest;
import com.example.yehia.studentsgo.service.ServiceProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AbstractClass {
    ArrayList<Passaggio> passaggi=new ArrayList();
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            //test dal prof.
        try {
            AsyncTaskTest test = new AsyncTaskTest();
            test.execute();
            Toast.makeText(this, test.get().toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("")        //URL DA INSERIRE
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PassagesService service = retrofit.create(PassagesService.class);
                final Call<List<Product>> callPassages;
                callPassages = service.listProducts();
                callPassages.enqueue(new Callback<List<Product>>() {

                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                        if (response.isSuccessful()) {

                            List<Product> productList = response.body();
                            MyAdapter myAdapter = new MyAdapter(ProductActivity.this, productList);
                            myAdapter.setOnClickListener(ProductActivity.this);
                            recyclerView.setAdapter(myAdapter);


                        } else {

                            Log.d("Response product", response.errorBody().toString());

                        }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                t.printStackTrace();

            }

        });
        */
    }

    public void AddPass(View view) {
        Intent intent = new Intent(this, AddPassActivity.class);
        startActivity(intent);
//        finish();
    }
}
