package com.example.onthiandroid.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class man1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtTenBan, txtTuoi;
        txtTenBan = findViewById(R.id.txtTenBan);
        txtTuoi = findViewById(R.id.txtTuoi);
        Spinner spMSSSV = findViewById(R.id.spMSSV);
        RadioButton rbtNam, rbtNu;
        rbtNam = findViewById(R.id.rbtNam);
        rbtNu = findViewById(R.id.rbtNu);
        CheckBox cbDaBong, cbGame;
        cbDaBong = findViewById(R.id.cbDaBong);
        cbGame = findViewById(R.id.cbGame);
        String []ma = new String[] {"123", "456", "789"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ma);
        spMSSSV.setAdapter(adapter);
        final String maso[] = {""};
        spMSSSV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maso[0] = ma[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button btLuu = findViewById(R.id.btluu);
        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtTenBan.getText().toString();
                String tuoi = txtTuoi.getText().toString();
                String bongDa = cbDaBong.getText().toString();
                String game = cbGame.getText().toString();
                String gioiTinh = "";
                if(rbtNam.isChecked()) {
                    gioiTinh = "Nam";
                } else if (rbtNu.isChecked()) {
                    gioiTinh = "Nữ";
                }
                String soThich = "";
                if(cbDaBong.isChecked()) {
                    soThich += bongDa + "-";
                }
                if(cbGame.isChecked()) {
                    soThich += game + "-";
                }
                Toast.makeText(man1.this, "Họ tên:" + ten + ", Mã SSSV:" + maso[0] + ", Tuổi:" + tuoi + ", Giới tính:" + gioiTinh + ", Sở thích:" + soThich, Toast.LENGTH_LONG ).show();
            }
        });

        Button btNext = findViewById(R.id.btnext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man1.this, man2.class);
                startActivity(in);
            }
        });

        Button btExit = findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
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