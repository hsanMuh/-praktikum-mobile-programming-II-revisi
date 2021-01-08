package com.example.praktikum_mobile_programming_2_revisi.UI.roomData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktikum_mobile_programming_2_revisi.R;
import com.example.praktikum_mobile_programming_2_revisi.UI.activity.MainActivity2;
import com.example.praktikum_mobile_programming_2_revisi.UI.adapter.RvAdapter;

public class RoomDataActivity extends AppCompatActivity {

    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);
        adapter = new RvAdapter();

        Button btnTambah =  findViewById(R.id.btnTambah);
        Button btnLihat =  findViewById(R.id.btnlihat);
        Button btncrud = findViewById(R.id.btncrud);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, AddRoomDataActivity.class);
                startActivity(i);
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, ViewRoomDataActivity.class);
                startActivity(i);
            }
        });

        btncrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }

}