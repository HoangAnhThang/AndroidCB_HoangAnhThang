package com.example.lab1_bai2_ltandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    TextView tvRandom;
    Random random = new Random();
    ImageView imgDice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getId();
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rdm = random.nextInt(6)+1;

                tvRandom.setText(String.valueOf(rdm));
                switch (rdm){
                    case 1: imgDice.setImageResource(R.drawable.dice1);
                        break;
                    case 2: imgDice.setImageResource(R.drawable.dice2);
                        break;
                    case 3: imgDice.setImageResource(R.drawable.dice3);
                        break;
                    case 4: imgDice.setImageResource(R.drawable.dice4);
                        break;
                    case 5: imgDice.setImageResource(R.drawable.dice5);
                        break;
                    case 6: imgDice.setImageResource(R.drawable.dice6);
                        break;
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getId(){
        btnRoll = findViewById(R.id.btnRoll);
        tvRandom = findViewById(R.id.tvRandom);
        imgDice = findViewById(R.id.imgDice);
    }
}