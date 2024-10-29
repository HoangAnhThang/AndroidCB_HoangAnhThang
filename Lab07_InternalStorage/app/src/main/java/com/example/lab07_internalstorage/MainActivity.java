package com.example.lab07_internalstorage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView txtDoc;
    EditText txtGhi;
    Button btnDoc,btnGhi;
    AutoCompleteTextView atV;
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
        txtDoc = findViewById(R.id.txtDoc);
        txtGhi = findViewById(R.id.txtGhi);
        btnDoc = findViewById(R.id.btnDoc);
        btnGhi = findViewById(R.id.btnGhi);
        atV = findViewById(R.id.atV);
        //set dữ liệu cho AutoCompleteTextView
        String[] dulieu = {"Quang Nam", "Quang Ngai", "Quang Binh",
                "Quang Tri", "Phan Rang", "Phu Quoc", "Binh Thuan", "Binh Thanh", "Binh Dai"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dulieu
        );
        atV.setAdapter(adapter);
        atV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                txtDoc.setText(atV.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnGhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
                    fos.write((txtGhi.getText() + "").getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fis = openFileInput("data.txt");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    String data = new String(buffer);
                    txtDoc.setText(data);
                    fis.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }
}