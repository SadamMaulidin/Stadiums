package com.example.stadiums.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StadiumResponse {

    @SerializedName("teams")
    private List<StadiumItem> teamItemList;

    public List<StadiumItem> getTeamItemList() {
        return teamItemList;
    }

    public void setTeamItemList(List<StadiumItem> teamItemList) {
        this.teamItemList = teamItemList;
    }
}
