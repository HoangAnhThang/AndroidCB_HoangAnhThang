package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init(){
        List<MyStories> lsStories = new ArrayList<MyStories>();
        lsStories.add(new MyStories(R.drawable.img, "Gia Dinh"));
        lsStories.add(new MyStories(R.drawable.img_1, "Giao thong"));
        lsStories.add(new MyStories(R.drawable.img_2, "Hoc Tap"));
        lsStories.add(new MyStories(R.drawable.img_3, "Giai Tri"));
        lsStories.add(new MyStories(R.drawable.img_4, "Cong An"));

        rcv = findViewById(R.id.rcv);
        AdapterStory myAdaper = new AdapterStory(lsStories);
        rcv.setAdapter(myAdaper);
        rcv.setLayoutManager(new GridLayoutManager(this, 1));
        //Thiet lap su kien click
        myAdaper.setOnItemClickListener(new AdapterStory.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent myintent = new Intent(MainActivity.this, DanhSachTruyen.class);
                myintent.putExtra("story_name", lsStories.get(position).getName());
                startActivity(myintent);
            }
        });

    }
}