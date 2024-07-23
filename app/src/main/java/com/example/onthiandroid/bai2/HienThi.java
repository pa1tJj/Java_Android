package com.example.onthiandroid.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;
import com.example.onthiandroid.bai1.SinhVien;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HienThi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hien_thi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btHienThi = findViewById(R.id.btthuchien);
        btHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listSV = new ArrayList<>();
                ListView lv = findViewById(R.id.lvDSSV);
                lv.setDivider(null);
                String json = "{\n" +
                        "  \"listSV\": [\n" +
                        "    {\n" +
                        "      \"maso\": \"pat01\",\n" +
                        "      \"hoten\": \"phan anh tuấn\",\n" +
                        "      \"tuoi\": 22\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"maso\": \"pat02\",\n" +
                        "      \"hoten\": \"mai thị mai\",\n" +
                        "      \"tuoi\": 20\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"maso\": \"pat03\",\n" +
                        "      \"hoten\": \"đinh tiên hoàng\",\n" +
                        "      \"tuoi\": 18\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray a = jsonObject.getJSONArray("listSV");
                    for (int i = 0; i < a.length(); i++) {
                        JSONObject ob = a.getJSONObject(i);
                        String s = ob.getString("maso") + "-" + ob.getString("hoten") + "-" + ob.getInt("tuoi");
                        listSV.add(s);
                    }
                    String []array = new String[3];
                    array = listSV.toArray(array);
                    ArrayAdapter adapter = new ArrayAdapter(HienThi.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, array);
                    lv.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}