package com.example.praktikum_mobile_programming_2_revisi.Database.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.praktikum_mobile_programming_2_revisi.Database.data.dao.MahasiswaDao;
import com.example.praktikum_mobile_programming_2_revisi.Database.data.model.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();
}
