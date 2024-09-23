package com.example.lab1_bai1_ltandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    EditText etX,etY;
    TextView tvKetQua;
    Button btncong;
    Button btntru;
    Button btnnhan, btnchianguyen,btnchiadu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        //Tao su kien cho click button +
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                int kq = x+y;
                tvKetQua.setText(String.valueOf(kq));
            }
        });
        //Xu ly su kien tru
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                int kq = x-y;
                tvKetQua.setText(String.valueOf(kq));
            }
        });
        //Xu ly su kien nhan
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                int kq = x*y;
                tvKetQua.setText(String.valueOf(kq));
            }
        });
        //Xu ly su kien click chia nguyen
        btnchianguyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                int kq = x/y;
                tvKetQua.setText(String.valueOf(kq));
            }
        });
        //Xu ly su kien click chia du
        btnchiadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                int kq = x%y;
                tvKetQua.setText(String.valueOf(kq));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Ham gan view cho cac doi tuong tuong ung
    private void initControl(){
        etX = findViewById(R.id.etX);
        etY = findViewById(R.id.etY);
        tvKetQua = findViewById(R.id.tvKetQua);
        btncong = findViewById(R.id.btncong);
        btntru  = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchianguyen = findViewById((R.id.btnchianguyen));
        btnchiadu   = findViewById(R.id.btnchiadu);
    }
}