package com.example.stadiums.Data.Lokal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.stadiums.Model.StadiumItem;

import java.util.List;


@Dao
public interface StadiumDao {

    @Insert
    void insertItem(StadiumItem stadiumItem);

    @Query("SELECT * FROM stadium WHERE idteam = :id")
    StadiumItem selectedItem(String id);

    @Delete
    void  deleteItem(StadiumItem stadiumItem);

    @Query("SELECT * FROM stadium ORDER BY strStadium ASC")
    List<StadiumItem> selectFavorite();

}
