package com.example.onthiandroid.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HienThiSinhVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hien_thi_sinh_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btHienThi = findViewById(R.id.btHienThi);
        btHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<SinhVien> listSV = new ArrayList<>();
                ListView lv = findViewById(R.id.lvSinhVien);
                lv.setDivider(null);
                String jSon = "{\n" +
                        "   \"listSV\":[\n" +
                        "      {\n" +
                        "         \"TenSV\":\"Phan Anh Tuấn\",\n" +
                        "         \"GioiTinh\":\"Nam\",\n" +
                        "         \"NamSinh\":\"2000\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "         \"TenSV\":\"Mai Thị Mai\",\n" +
                        "         \"GioiTinh\":\"Nữ\",\n" +
                        "         \"NamSinh\":\"2004\"\n" +
                        "      }\n" +
                        "   ]\n" +
                        "}";

                try {
                    JSONObject object = new JSONObject(jSon);
                    JSONArray a = object.getJSONArray("listSV");
                    for (int i = 0; i< a.length(); i++) {
                        JSONObject ob = a.getJSONObject(i);
                        SinhVien sv = new SinhVien(ob.getString("TenSV"), ob.getString("GioiTinh"), ob.getString("NamSinh"));
                        listSV.add(sv);
                    }
                    SinhVienAdapter adapter = new SinhVienAdapter(HienThiSinhVien.this, R.layout.activity_item, listSV);
                    lv.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(HienThiSinhVien.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}