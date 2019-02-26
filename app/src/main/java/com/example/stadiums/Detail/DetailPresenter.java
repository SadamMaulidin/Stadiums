package com.example.stadiums.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.stadiums.Data.Lokal.StadiumDatabase;
import com.example.stadiums.Model.StadiumItem;
import com.example.stadiums.Urils.Constans;

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.View view;
    private StadiumDatabase stadiumDatabase;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailStadium(Bundle bundle) {
        if (bundle != null){
            StadiumItem stadiumItem = (StadiumItem) bundle.getSerializable(Constans.KEY_DATA);
            view.showDetailStadium(stadiumItem);
        }else {
            view.showFailure("Empty");
        }
    }

    @Override
    public void addToFavorite(Context context, StadiumItem stadiumItem) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDao().insertItem(stadiumItem);
        view.showSuccess("Favorite Saved");
    }

    @Override
    public void removeFavorite(Context context, StadiumItem stadiumItem) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDao().deleteItem(stadiumItem);
        view.showSuccess("Favorite Removed");
    }

    @Override
    public Boolean checkFavorite(Context context, StadiumItem stadiumItem) {
        Boolean favorite = false;
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        return favorite = stadiumDatabase.stadiumDao().selectedItem(stadiumItem.getIdTeam()) != null;
    }
}
