package com.example.onthiandroid.bai4;

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

public class DangKyMonHoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky_mon_hoc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox cbJava, cbC, cbAndroid;
        cbJava = findViewById(R.id.cbJava);
        cbC = findViewById(R.id.cbC);
        cbAndroid = findViewById(R.id.cbAndroid);
        RadioButton rbNam, rbNu;
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        Button btCho, btExit, btNext;
        btCho = findViewById(R.id.btCho4);
        btExit = findViewById(R.id.btExit4);
        btNext = findViewById(R.id.btnext4);
        btCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String java = cbJava.getText().toString();
                String c = cbC.getText().toString();
                String and = cbAndroid.getText().toString();
                String nam = rbNam.getText().toString();
                String nu = rbNu.getText().toString();
                String mon = "";
                if(cbJava.isChecked()) {
                    mon += java + "-";
                }
                if(cbC.isChecked()) {
                    mon += c + "-";
                }
                if(cbAndroid.isChecked()) {
                    mon += and;
                }
                String gioiTinh = "";
                if(rbNam.isChecked()) {
                    gioiTinh = nam;
                } else if (rbNu.isChecked()) {
                    gioiTinh = nu;
                }
                Toast.makeText(DangKyMonHoc.this, mon + ", " + gioiTinh, Toast.LENGTH_SHORT ).show();
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
                Intent in = new Intent(DangKyMonHoc.this, man4_bai4.class);
                startActivity(in);
            }
        });
    }
}