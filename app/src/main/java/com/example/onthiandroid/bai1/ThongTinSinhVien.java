package com.example.onthiandroid.bai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class ThongTinSinhVien extends AppCompatActivity {

    EditText txtTenSV;
    RadioButton rbNam, rbNu;
    CheckBox cbBongDa, cbCauLong, cbBongBan, cbBongChuyen;
    Button btThoat, btXacNhan, btTiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();
        btXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = txtTenSV.getText().toString();
                String bongDa = cbBongDa.getText().toString();
                String bongBan = cbBongBan.getText().toString();
                String bongChuyen = cbBongChuyen.getText().toString();
                String cauLong = cbCauLong.getText().toString();
                String gioiTinh = "";
                if(rbNam.isChecked()) {
                    gioiTinh = "Nam";
                } else if (rbNu.isChecked()) {
                    gioiTinh = "Nữ";
                }
                String soThich = "";
                if(cbBongBan.isChecked()) {
                    soThich += bongBan + "-";
                }
                if(cbBongChuyen.isChecked()) {
                    soThich += bongChuyen + "-";
                }
                if(cbBongDa.isChecked()) {
                    soThich += bongDa + "-";
                }
                if(cbCauLong.isChecked()) {
                    soThich += cauLong + "-";
                }

                Toast.makeText(ThongTinSinhVien.this, hoTen + ", " + gioiTinh + ", " + soThich, Toast.LENGTH_SHORT).show();
            }
        });

        btTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ThongTinSinhVien.this, MonAn.class);
                startActivity(in);
            }
        });

        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
                finish();
            }
        });

    }

    public void anhXa() {
        txtTenSV = findViewById(R.id.txtTenSV);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        cbBongBan = findViewById(R.id.cbBongBan);
        cbBongDa = findViewById(R.id.cbBongDa);
        cbCauLong = findViewById(R.id.cbCauLong);
        cbBongChuyen = findViewById(R.id.cbBongChuyen);
        btTiep = findViewById(R.id.btTiep);
        btThoat = findViewById(R.id.btThoat);
        btXacNhan = findViewById(R.id.btXacNhan);
    }
}