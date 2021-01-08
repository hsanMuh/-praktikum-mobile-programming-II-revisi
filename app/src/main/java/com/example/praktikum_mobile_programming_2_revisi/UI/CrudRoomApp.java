package com.example.praktikum_mobile_programming_2_revisi.UI;

import android.app.Application;

import androidx.room.Room;

import com.example.praktikum_mobile_programming_2_revisi.Database.data.db.AppDatabase;
import com.example.praktikum_mobile_programming_2_revisi.Database.data.db.DataBaseMigrations;

/**
 * Created on : 06/11/20
 * Author     : mmnuradityo
 * GitHub     : https://github.com/mmnuradityo
 */
public class CrudRoomApp extends Application {

    private static CrudRoomApp INSTANCE;
    private AppDatabase dataBase;

    public static CrudRoomApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this, AppDatabase.class, "database_mahasiswa")
                .addMigrations(DataBaseMigrations.MIGRATION_1_TO_2)
                .allowMainThreadQueries()
                .build();

        INSTANCE = this;
    }

    public AppDatabase getDataBase() {
        return dataBase;
    }

}
