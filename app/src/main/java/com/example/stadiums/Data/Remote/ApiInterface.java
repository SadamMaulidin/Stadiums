package com.example.stadiums.Data.Remote;

import com.example.stadiums.Model.StadiumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<StadiumResponse> getAllTeam(@Query("s") String s, @Query("c") String c);
}
