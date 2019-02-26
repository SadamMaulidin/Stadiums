package com.example.stadiums.Data.Lokal;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.stadiums.Model.StadiumItem;

@Database(entities = StadiumItem.class, version = 1)
public abstract class StadiumDatabase extends RoomDatabase {

    public abstract StadiumDao stadiumDao();
    private static StadiumDatabase stadiumDatabase;
    public static StadiumDatabase getStadiumDatabase(Context context){
        synchronized (StadiumDatabase.class){
            if (stadiumDatabase == null){
                stadiumDatabase = Room.databaseBuilder(context, StadiumDatabase.class, "dbStadium").allowMainThreadQueries().build();
            }
        }return stadiumDatabase;
    }

}
