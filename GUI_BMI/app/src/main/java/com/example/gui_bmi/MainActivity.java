package com.example.gui_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Khai bao bien tuong ung dieu khien
    EditText txt_Name,txt_ChieuCao,txt_CanNang;
    TextView txt_BMI,txt_ChuanDoan;

    Button btn_tinhBMI;
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

        btn_tinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cannang = Double.parseDouble(txt_CanNang.getText().toString());
                double chieucao = Double.parseDouble(txt_ChieuCao.getText().toString())/100;
                double BMI = cannang / (chieucao * chieucao);



                txt_BMI.setText(String.valueOf(BMI));
                if (BMI<18)
                    txt_ChuanDoan.setText(txt_Name.getText() +"\t Gay lam nha");
                else if (BMI<=24.9) {
                    txt_ChuanDoan.setText(txt_Name.getText() +"\t Binh thuong day cu tiep tuc");
                } else if (BMI<=29.9) {
                    txt_ChuanDoan.setText(txt_Name.getText() +"\t Beo phi cap do 1 roi :(");
                    
                } else if (BMI<=34.9) {
                    txt_ChuanDoan.setText(txt_Name.getText() +"\t Beo phi cap do 2 roi can than :(((");
                }
                else
                    txt_ChuanDoan.setText(txt_Name.getText() +"\t Beo phi cap do 3 roi nguy hiem lam :(((((");
            }
        });
    }

    //Ham gan dieu khien
    void ganDieuKhien(){
        txt_Name = findViewById(R.id.txt_Name);
        txt_ChieuCao = findViewById(R.id.txt_ChieuCao);
        txt_CanNang = findViewById(R.id.txt_CanNang);
        txt_BMI = findViewById(R.id.txt_BMI);
        txt_ChuanDoan = findViewById(R.id.txt_ChuanDoan);

        btn_tinhBMI= findViewById(R.id.btn_tinhBMI);
    }
}