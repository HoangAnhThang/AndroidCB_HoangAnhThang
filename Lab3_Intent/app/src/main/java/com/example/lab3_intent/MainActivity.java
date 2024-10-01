package com.example.lab3_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    Button btnSearch, btnView;
    Button btnCall, btnSend,btnDial;
    Button btnPic,btnMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ganDieuKhien();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.vn"));
                startActivity(intent);
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel: (+84)362381679"));
                startActivity(intent);
            }
        });
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: (+84)362381679"));
                startActivity(intent);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Intent.ACTION_SENDTO, Uri.parse("sms:(+84)362381679"));
                intent.putExtra("sms_body", "Di hoc ve di cho mua do an");
                startActivity(intent);
            }
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(myActivity2);
            }
        });

        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.setType("image/pictures/*");
                myIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(myIntent);
            }
        });
    }

    void ganDieuKhien(){
        btnSearch = findViewById(R.id.btnSearch);
        btnCall = findViewById(R.id.btnCall);
        btnDial = findViewById(R.id.btnDial);
        btnView = findViewById(R.id.btnView);
        btnSend = findViewById( R.id.btnSend);
        btnMusic = findViewById(R.id.btnMusic);
        btnPic = findViewById(R.id.btnPic);
    }
}