package com.example.gui_doinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai bao bien tuong ung cac dieu khien
    EditText txt_F,txt_C;
    Button btn_FtoC,btn_CtoF,btn_Clear;
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
        btn_CtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x = Float.parseFloat(txt_C.getText().toString());
                double y = (x*(9/5.0) +32);
                txt_F.setText(String.valueOf(y));
            }
        });

        btn_FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x = Float.parseFloat(txt_F.getText().toString());
                double y = (x-32) * (5/9.0);
                txt_C.setText(String.valueOf(y));
            }
        });

        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_F.setText("");
                txt_C.setText("");
            }
        });
    }
    //Gan cac dieu khien cho bien
    void ganDieuKhien(){
        txt_F = findViewById(R.id.txt_F);
        txt_C = findViewById(R.id.txt_C);

        btn_CtoF = findViewById(R.id.btn_CtoF);
        btn_FtoC = findViewById(R.id.btn_FtoC);
        btn_Clear = findViewById(R.id.btn_Clear);
    }
}