package com.example.calculatorver2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {
    TextView txt_BieuThuc,txt_KetQua;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btn_Cong,btn_Tru,btn_Nhan,btn_Chia,btn_Phay;
    Button btn_MoNgoac,btn_DongNgoac,btn_Bang;
    Button btn_Del, btn_AC;
    String chuoiBieuThuc ="";
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

        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc = "";
                txt_BieuThuc.setText(chuoiBieuThuc);
                txt_KetQua.setText("");
            }
        });
        btn_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!chuoiBieuThuc.isEmpty()) {
                    chuoiBieuThuc = chuoiBieuThuc.substring(0, chuoiBieuThuc.length() - 1);

                    // Cập nhật lại TextView sau khi xóa
                    txt_BieuThuc.setText(chuoiBieuThuc);
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "0";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "1";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "2";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "3";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "4";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "5";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "6";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "7";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "8";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "9";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });

        btn_Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "+";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn_Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "-";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn_Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "*";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn_Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "/";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn_Phay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += ",";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });

        btn_MoNgoac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += "(";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });
        btn_DongNgoac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuoiBieuThuc += ")";
                txt_BieuThuc.setText(chuoiBieuThuc);
            }
        });

        btn_Bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new ExpressionBuilder(chuoiBieuThuc).build();
                double result = expression.evaluate();
                // Hiển thị kết quả
                txt_KetQua.setText(String.valueOf(result));
                // Xóa chuỗi sau khi hiển thị
                chuoiBieuThuc ="";
            }
        });
    }


    void ganDieuKhien(){
         txt_BieuThuc = findViewById(R.id.txt_BieuThuc);
        txt_KetQua = findViewById(R.id.txt_KetQua);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        btn_Cong = findViewById(R.id.btn_Cong);
        btn_Tru = findViewById(R.id.btn_Tru);
        btn_Nhan = findViewById(R.id.btn_Nhan);
        btn_Chia = findViewById(R.id.btn_Chia);
        btn_Phay = findViewById(R.id.btn_Phay);

        btn_MoNgoac = findViewById(R.id.btn_MoNgoac);
        btn_DongNgoac = findViewById(R.id.btn_DongNgoac);
        btn_Bang = findViewById(R.id.btn_Bang);

        btn_Del= findViewById(R.id.btn_Del);
        btn_AC = findViewById(R.id.btn_AC);
    }
}