package com.example.lab7_datastorage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt_User,txt_Password;
    CheckBox cbLuu;
    Button btnLogin;
    @SuppressLint("MissingInflatedId")
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
        txt_User = findViewById(R.id.txt_User);
        txt_Password = findViewById(R.id.txt_Password);
        cbLuu = findViewById(R.id.cbLuu);
        btnLogin = findViewById(R.id.btn_Login);

        //xu ly nut login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savingPref();
                Intent intent = new Intent(MainActivity.this,LoginSucces.class);
                //truyen du lieu qua man hinh moi
                intent.putExtra("user",txt_User.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //luu trang thai
        savingPref();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //doc trang thai
        restoring();
    }

    //Lay du lieu
    private void restoring(){
        SharedPreferences pre = this.getSharedPreferences("storage", Context.MODE_PRIVATE);


              boolean check = pre.getBoolean("checked",false);
             if(check){
                 String user = pre.getString("user","admin");
                 String password = pre.getString("password","123");
                 txt_User.setText(user);
                 txt_Password.setText(password);
             }
            cbLuu.setChecked(check);

    }
//Luu du lieu
    private  void  savingPref(){
        //tao doi tuong share pref
        SharedPreferences pre = this.getSharedPreferences("storage",Context.MODE_PRIVATE);
        //tao editor
        SharedPreferences.Editor editor = pre.edit();
        //luu du lieu key value
        String user = txt_User.getText().toString();
        String password = txt_Password.getText().toString();
        boolean check = cbLuu.isChecked();
        if(!check){
            editor.clear();
        }
        else {
            //luu vao editor
            editor.putString("user",user);
            editor.putString("password",password);

        }
        editor.putBoolean("checked", check);
        editor.commit();
    }
}