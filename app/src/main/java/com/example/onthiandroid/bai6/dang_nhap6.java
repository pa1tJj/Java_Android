package com.example.onthiandroid.bai6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;
import com.example.onthiandroid.bai5.dang_nhap5;
import com.example.onthiandroid.bai5.man2_bai5;

public class dang_nhap6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtuser = findViewById(R.id.txtuser6);
        EditText txtpass = findViewById(R.id.txtpass6);
        Button btlogin = findViewById(R.id.btlogin6);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = txtpass.getText().toString();
                String ten = txtuser.getText().toString();
                if(ten.equals("")) {
                    Toast.makeText(dang_nhap6.this, "chưa nhập tên người dùng", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(dang_nhap6.this, "chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else if(ten.equals("admin") && pass.equals("123")) {
                    Intent in = new Intent(dang_nhap6.this, man2_bai6.class);
                    startActivity(in);
                } else if(!ten.equals("admin")){
                    Toast.makeText(dang_nhap6.this, "tên người dùng không đúng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(dang_nhap6.this, "mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}