package com.example.onthiandroid.bai3;

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

public class DangNhap_bai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtten = findViewById(R.id.txtten);
        EditText txtpass3 = findViewById(R.id.txtpass3);
        Button btSignin, btexit;
        btSignin = findViewById(R.id.btSignin);
        btexit = findViewById(R.id.btexit);
        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtten.getText().toString();
                String pass = txtpass3.getText().toString();
                if(ten.equals("admin") && pass.equals("123")) {
                    Intent in = new Intent(DangNhap_bai3.this, DanhSachDoUong.class);
                    startActivity(in);
                } else {
                    Toast.makeText(DangNhap_bai3.this, "Username hoặc pass sai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
                finish();
            }
        });
    }
}