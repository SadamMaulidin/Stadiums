package com.example.stadiums.Data.Remote;

import com.example.stadiums.Urils.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder().baseUrl(Constans.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

}
