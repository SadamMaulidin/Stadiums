package com.example.stadiums.UI.Favorite;

import android.content.Context;

import com.example.stadiums.Model.StadiumItem;

import java.util.List;

public interface FavoriteContract {
    interface View{
        void showDataList(List<StadiumItem> stadiumItemList);
        void showFailure(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getdataListStadium(Context context);
    }
}
