package com.bgsourcingltd.retrofitpractice;


import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> getRegisterApi(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Body HashMap<String,Object> orderlist
            );

}
