package com.example.gui_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText txt_A,txt_B;
    TextView txt_KQ;
    Button btn_Tong, btn_Hieu,btn_Tich,btn_Thuong,btn_UCLN,btn_Exit;



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
        //Goi ham gan dieu khien
        ganDieuKhien();

        //Xu ly event
        btn_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_A.getText().toString());
                int b = Integer.parseInt(txt_B.getText().toString());
                int kq = a+b;
                txt_KQ.setText(String.valueOf(kq));
            }
        });

        btn_Hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_A.getText().toString());
                int b = Integer.parseInt(txt_B.getText().toString());
                int kq = a-b;
                txt_KQ.setText(String.valueOf(kq));
            }
        });

        btn_Tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_A.getText().toString());
                int b = Integer.parseInt(txt_B.getText().toString());
                int kq = a*b;
                txt_KQ.setText(String.valueOf(kq));
            }
        });

        btn_Thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_A.getText().toString());
                int b = Integer.parseInt(txt_B.getText().toString());
                int kq = a/b;
                txt_KQ.setText(String.valueOf(kq));
            }
        });

        btn_UCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_A.getText().toString());
                int b = Integer.parseInt(txt_B.getText().toString());

                while (b!=0){
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                txt_KQ.setText(String.valueOf(a));

            }
        });

        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void ganDieuKhien(){
        //Gan view
        txt_A = findViewById(R.id.txt_A);
        txt_B = findViewById(R.id.txt_B);
        txt_KQ = findViewById(R.id.txt_KQ);

        //Gan button
        btn_Tong = findViewById(R.id.btn_Tong);
        btn_Hieu = findViewById(R.id.btn_Hieu);
        btn_Tich = findViewById(R.id.btn_Tich);
        btn_Thuong = findViewById(R.id.btn_Thuong);
        btn_UCLN = findViewById(R.id.btn_UCLN);
        btn_Exit = findViewById(R.id.btn_Exit);
    }


}