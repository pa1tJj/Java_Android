package com.example.onthiandroid.bai4;

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

public class dang_nhap4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtUser = findViewById(R.id.txtten4);
        EditText txtpass = findViewById(R.id.txtpass4);
        Button btSign, btExit;
        btSign = findViewById(R.id.btSignin4);
        btExit = findViewById(R.id.btexit4);
        btSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtUser.getText().toString();
                String pass = txtpass.getText().toString();
                if(ten.equals("") || pass.equals("")) {
                    Toast.makeText(dang_nhap4.this, "Trường dữ liệu bị bỏ trống", Toast.LENGTH_SHORT).show();
                } else if(ten.equals("admin") && pass.equals("123")) {
                    Intent in = new Intent(dang_nhap4.this, DangKyMonHoc.class);
                    startActivity(in);
                } else {
                    Toast.makeText(dang_nhap4.this, "tên hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}