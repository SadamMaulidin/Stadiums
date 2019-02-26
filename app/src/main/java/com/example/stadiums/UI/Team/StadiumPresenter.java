package com.example.stadiums.UI.Team;

import com.example.stadiums.Data.Remote.ApiClient;
import com.example.stadiums.Data.Remote.ApiInterface;
import com.example.stadiums.Model.StadiumResponse;
import com.example.stadiums.Urils.Constans;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StadiumPresenter implements StadiumContract.Presenter{

    private final StadiumContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public StadiumPresenter(StadiumContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataList() {
        view.showProgress();
        Call<StadiumResponse> call = apiInterface.getAllTeam(Constans.s, Constans.c);
        call.enqueue(new Callback<StadiumResponse>() {
            @Override
            public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                view.hideProgress();
                if (response.body() != null){
                    view.showDataList(response.body().getTeamItemList());
                }else {
                    view.showFailure("Load Failed");
                }
            }

            @Override
            public void onFailure(Call<StadiumResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailure(t.getMessage());
            }
        });
    }
}
