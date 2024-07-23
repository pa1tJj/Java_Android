package com.example.onthiandroid.bai2;

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

public class DangNhap2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btDangNhap, btKetThuc;
        EditText txtTenNG, txtPass;
        txtTenNG = findViewById(R.id.txtTenNG);
        txtPass = findViewById(R.id.txtPass);
        btDangNhap = findViewById(R.id.btDangNhap);
        btKetThuc = findViewById(R.id.btKetThuc);
        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtTenNG.getText().toString();
                String mk = txtPass.getText().toString();

                if(ten.equals("admin") && mk.equals("123")) {
                    Intent in = new Intent(DangNhap2.this, DanhSachBaiToan.class);
                    startActivity(in);
                } else {
                    Toast.makeText(DangNhap2.this, "Tên người dùng hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
            }
        });
    }
}