package com.bgsourcingltd.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private List<ProductModel> productModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        productModelList = new ArrayList<>();
        productModelList.add(new ProductModel("Ice cream","20"));
        productModelList.add(new ProductModel("Chocolet","30"));
        productModelList.add(new ProductModel("Muri","10"));
        productModelList.add(new ProductModel("Sandwitch","200"));

        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
        intent.putExtra("order", (Serializable) productModelList);
        startActivity(intent);
    }
}