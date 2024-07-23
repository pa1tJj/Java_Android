package com.example.onthiandroid.bai7;

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

public class man2_bai7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2_bai7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox cbjava, cbc, cbandroid;
        RadioButton rbnam, rbnu;
        cbjava = findViewById(R.id.cbJava7);
        cbc = findViewById(R.id.cbC7);
        cbandroid = findViewById(R.id.cbAndroid7);
        rbnam = findViewById(R.id.rbNam7);
        rbnu = findViewById(R.id.rbNu7);
        Button btcho, btexxit, btnext;
        btcho = findViewById(R.id.btCho7);
        btexxit = findViewById(R.id.btExit7);
        btnext = findViewById(R.id.btnext7);
        btcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = "";
                String gioiTinh = "";
                if(cbjava.isChecked()) {
                    monHoc += cbjava.getText().toString() + "-";
                }
                if(cbc.isChecked()) {
                    monHoc += cbc.getText().toString() + "-";
                }
                if(cbandroid.isChecked()) {
                    monHoc += cbandroid.getText().toString() + "-";
                }
                if(rbnam.isChecked()) {
                    gioiTinh = rbnam.getText().toString();
                } else {
                    gioiTinh = rbnu.getText().toString();
                }
                Toast.makeText(man2_bai7.this, monHoc + ", " + gioiTinh, Toast.LENGTH_SHORT).show();
            }
        });

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man2_bai7.this, man3_bai7.class);
                startActivity(in);
            }
        });

        btexxit.setOnClickListener(new View.OnClickListener() {
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