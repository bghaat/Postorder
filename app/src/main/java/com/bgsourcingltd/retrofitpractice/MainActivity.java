package com.bgsourcingltd.retrofitpractice;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, phoneEt, locationEt;
    private MaterialButton submitBtn;
    private ApiService apiService;
    private List<ProductModel> list;
    HashMap<String, Object> cartmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.et_name);
        phoneEt = findViewById(R.id.et_phone);
        locationEt = findViewById(R.id.et_phone);
        submitBtn = findViewById(R.id.btn_submit);

        list = (List<ProductModel>) getIntent().getSerializableExtra("order");
        Log.d("list", "onCreate: " + list.get(1).getProductName());


        for (ProductModel model : list) {
            cartmap = new HashMap<>();
            cartmap.put("productname", model.getProductName());
            cartmap.put("productprice", model.getPrice());

            Log.d("cartmap", "onCreate: " +
                    cartmap);


            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nameEt.getText().toString();
                    String phone = phoneEt.getText().toString();
                    String location = locationEt.getText().toString();


                    apiService = ApiClient.getRetrofit().create(ApiService.class);

                    Call<RegisterResponse> responseCall = apiService.getRegisterApi(name, phone, location, cartmap);
                    responseCall.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                            RegisterResponse registerResponse = response.body();

                            Toast.makeText(MainActivity.this, "" + registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {

                        }
                    });

                }
            });


        }


    }
}