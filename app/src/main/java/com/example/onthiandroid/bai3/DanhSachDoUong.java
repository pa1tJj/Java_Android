package com.example.onthiandroid.bai3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class DanhSachDoUong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_do_uong);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btCho, btExit, btNext;
        btCho= findViewById(R.id.btCho);
        btExit = findViewById(R.id.btExit3);
        btNext = findViewById(R.id.btnext3);
        CheckBox cbCafe , cbSua, cbCam;
        cbCafe = findViewById(R.id.cbCafe);
        cbSua = findViewById(R.id.cbSua);
        cbCam = findViewById(R.id.cbCam);
        String cafe = cbCafe.getText().toString();
        String sua = cbSua.getText().toString();
        String cam = cbCam.getText().toString();
        RadioButton rb20, rb25, rb30;
        rb20 = findViewById(R.id.rb20);
        rb25 = findViewById(R.id.rb25);
        rb30 = findViewById(R.id.rb30);

        btCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String luaChon = "";
                if(cbCafe.isChecked()) {
                    luaChon += cafe + "-";
                }
                if(cbSua.isChecked()) {
                    luaChon += sua + "-";
                }
                if(cbCam.isChecked()) {
                    luaChon += cam;
                }
                int gia;
                String hienThiGia = "";
                if(rb20.isChecked()) {
                    gia = 20000;
                    hienThiGia = gia + "đ";
                } else if(rb25.isChecked()) {
                    gia = 25000;
                    hienThiGia = gia + "đ";
                } else {
                    gia = 30000;
                    hienThiGia = gia + "đ";
                }
                String s = luaChon + ":" + hienThiGia;
                Toast.makeText(DanhSachDoUong.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
                finish();
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DanhSachDoUong.this, man3_bai3.class);
                startActivity(in);
            }
        });
    }
}