package com.example.praktikum_mobile_programming_2_revisi.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktikum_mobile_programming_2_revisi.R;
import com.example.praktikum_mobile_programming_2_revisi.UI.roomData.RoomDataActivity;
import com.example.praktikum_mobile_programming_2_revisi.UI.sharedPref.SharedPrefActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnToShared =  findViewById(R.id.btnToSharedPref);
        Button btnToRoom =  findViewById(R.id.btnToRoomData);
        Button btnLogin =  findViewById(R.id.btnLogin);

        btnToShared.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SharedPrefActivity.class);
            startActivity(intent);
        });

        btnToRoom.setOnClickListener(v -> {
            Intent i = new Intent(HomeActivity.this, RoomDataActivity.class);
            startActivity(i);
        });


        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(i);
        });

    }
}
