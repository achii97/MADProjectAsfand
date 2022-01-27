package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AsfandMethods {

    @GET("api/v1/getCompanies")
    Call<AsfandModel> getAllData();



}
