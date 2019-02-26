package com.example.stadiums.UI.Team;

import com.example.stadiums.Model.StadiumItem;

import java.util.List;

public interface StadiumContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<StadiumItem> stadiumItemList);
        void showFailure(String msg);
    }

    interface Presenter{
        void getDataList();
    }
}
