package com.example.database_lite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Person.class},version = 1)
public abstract class PersonDataBase extends RoomDatabase {
    public abstract PersonDAO getPersonDAO();
    public static PersonDataBase INSTANCE;
    public static PersonDataBase getDBinstance (Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PersonDataBase.class,"Person")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
