package com.example.onthiandroid.bai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

import java.util.ArrayList;

public class DanhSachBaiToan extends AppCompatActivity {

    ArrayList<String> listBT = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_bai_toan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.lvBaiToan);
        String []a = new String[] {"Cộng", "Trừ", "Nhân", "Chia", "JSON"};
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, a);
        lv.setAdapter(adapter);
        final int []index = {-1};
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index[0] = i;
            }
        });

        Button btThucHien, btThoat;
        btThucHien = findViewById(R.id.btThucHien);
        btThoat = findViewById(R.id.btThoat2);
        btThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index[0] == -1) {
                    Toast.makeText(DanhSachBaiToan.this, "Chưa chọn bài toán", Toast.LENGTH_SHORT).show();
                } else if(index[0] == 0) {
                    Intent in = new Intent(DanhSachBaiToan.this, PhepCong.class);
                    startActivity(in);
                } else if(index[0] == 4) {
                    Intent in = new Intent(DanhSachBaiToan.this, HienThi.class);
                    startActivity(in);
                }
            }
        });
    }
}