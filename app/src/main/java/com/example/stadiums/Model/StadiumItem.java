package com.example.stadiums.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "stadium")
public class StadiumItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idteam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String teamName;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String teamLogo;

    @ColumnInfo(name = "strLeague")
    @SerializedName("strLeague")
    private String league;

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    private String descript;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String stadiumName;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String stadiumImg;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String stadiumDesc;
    @ColumnInfo(name = "strStadiumLocation")
    @SerializedName("strStadiumLocation")
    private String stadiumLoc;

    public String getStadiumLoc() {
        return stadiumLoc;
    }

    public void setStadiumLoc(String stadiumLoc) {
        this.stadiumLoc = stadiumLoc;
    }


    public StadiumItem(@NonNull String idTeam, String teamName, String teamLogo, String league, String descript, String stadiumName, String stadiumImg, String stadiumDesc, String stadiumLoc) {
        this.idTeam = idTeam;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.league = league;
        this.descript = descript;
        this.stadiumName = stadiumName;
        this.stadiumImg = stadiumImg;
        this.stadiumDesc = stadiumDesc;
        this.stadiumLoc = stadiumLoc;

    }

    @NonNull
    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(@NonNull String idTeam) {
        this.idTeam = idTeam;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStadiumImg() {
        return stadiumImg;
    }

    public void setStadiumImg(String stadiumImg) {
        this.stadiumImg = stadiumImg;
    }

    public String getStadiumDesc() {
        return stadiumDesc;
    }

    public void setStadiumDesc(String stadiumDesc) {
        this.stadiumDesc = stadiumDesc;
    }
}
