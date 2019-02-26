package com.example.stadiums.UI.Favorite;

import android.content.Context;

import com.example.stadiums.Data.Lokal.StadiumDatabase;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private StadiumDatabase stadiumDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getdataListStadium(Context context) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        if (stadiumDatabase.stadiumDao().selectFavorite() != null){
            view.showDataList(stadiumDatabase.stadiumDao().selectFavorite());
        }else {
            view.showFailure("Favorite is empty");
        }
        view.hideRefresh();
    }
}
