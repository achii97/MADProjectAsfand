package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsfandRetrofitClient {

    private static Retrofit retrofit;
    private static String Base_URL = "https://c-company.herokuapp.com/";

    public static Retrofit getRetrofitInstance ()
    {
        if ( retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }



}
