package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04;

import android.app.Person;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao.NurseDao;

@Database(entities = {Person.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "MedicalRoomDB";
    public abstract NurseDao nurseDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
