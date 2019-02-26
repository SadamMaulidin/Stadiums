package com.example.stadiums.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.stadiums.Model.StadiumItem;

public interface DetailContract {
    interface View{
        void showDetailStadium(StadiumItem stadiumItem);
        void showFailure(String msg);
        void showSuccess(String msg);
    }

    interface Presenter{
        void getDetailStadium(Bundle bundle);
        void addToFavorite(Context context, StadiumItem stadiumItem);
        void removeFavorite(Context context, StadiumItem stadiumItem);
        Boolean checkFavorite(Context context, StadiumItem stadiumItem);
    }
}
