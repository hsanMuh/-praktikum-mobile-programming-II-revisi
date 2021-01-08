package com.example.praktikum_mobile_programming_2_revisi.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktikum_mobile_programming_2_revisi.R;
import com.example.praktikum_mobile_programming_2_revisi.UI.sharedPref.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private SharedPrefManager sharedPrefManager;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private ProgressBar pbLogin;
    private ImageView ivLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefManager = new SharedPrefManager(this);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnSignIn);
        pbLogin = findViewById(R.id.pBLogin);
        ivLogin = findViewById(R.id.ivLogin);

        login();
    }

    private void login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                pbLogin.setVisibility(View.VISIBLE);
                ivLogin.setVisibility(View.GONE);

                if (username.isEmpty() || password.isEmpty()){
                    pbLogin.setVisibility(View.GONE);
                    ivLogin.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                }else{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String spUsername = sharedPrefManager.getUsername();
                            String spPassword = sharedPrefManager.getPassword();

                            Log.d("username","user"+username);
                            Log.d("password","pass"+password);

                            if (username.equals(spUsername) && password.equals(spPassword)){
                                Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                                sharedPrefManager.saveIsLogin(true);
                                finishAffinity();
                                startActivity(i);
                            }else {
                                pbLogin.setVisibility(View.GONE);
                                ivLogin.setVisibility(View.VISIBLE);
                                Toast.makeText(LoginActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 3000);
                }
            }
        });
    }
}