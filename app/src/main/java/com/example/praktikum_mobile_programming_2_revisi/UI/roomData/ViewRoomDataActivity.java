package com.example.praktikum_mobile_programming_2_revisi.UI.roomData;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum_mobile_programming_2_revisi.Database.adapter.RecyclerViewAdapter;
import com.example.praktikum_mobile_programming_2_revisi.Database.data.model.Mahasiswa;
import com.example.praktikum_mobile_programming_2_revisi.R;
import com.example.praktikum_mobile_programming_2_revisi.UI.CrudRoomApp;

import java.util.ArrayList;
import java.util.List;

import static com.example.praktikum_mobile_programming_2_revisi.Database.data.db.MyApp.db;

public class ViewRoomDataActivity extends AppCompatActivity {

    RecyclerView myRecyclerview;
    RecyclerViewAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_data);
        myRecyclerview = findViewById(R.id.myRecyclerview);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = CrudRoomApp.getInstance().getDataBase();
        listMahasiswas = db.userDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNim()+i);
        }
    }
    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter = new RecyclerViewAdapter(this,listMahasiswas);
    }
    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }
}