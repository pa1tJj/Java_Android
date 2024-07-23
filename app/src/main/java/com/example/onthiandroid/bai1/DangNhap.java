package com.example.onthiandroid.bai1;

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

public class DangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText ten = findViewById(R.id.txtTen);
        EditText matkhau = findViewById(R.id.txtMatKhau);
        Button dangnhap, ketthuc;
        dangnhap = findViewById(R.id.btDangNhap);
        ketthuc = findViewById(R.id.btKetThuc);
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
                finish();
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tendn = ten.getText().toString();
                String mk = matkhau.getText().toString();
                if(tendn.equals("admin") && mk.equals("123")) {
                    Intent in = new Intent(DangNhap.this, ThongTinSinhVien.class);
                    startActivity(in);
                } else if (!tendn.equals("admin")){
                    Toast.makeText(DangNhap.this, "Tên đăng nhập sai", Toast.LENGTH_SHORT).show();
                } else if (!mk.equals("admin")){
                    Toast.makeText(DangNhap.this, "Mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}