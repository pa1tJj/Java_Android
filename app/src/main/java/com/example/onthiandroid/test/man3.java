package com.example.onthiandroid.test;

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
import com.example.onthiandroid.bai1.HienThiSinhVien;
import com.example.onthiandroid.bai1.SinhVien;
import com.example.onthiandroid.bai1.SinhVienAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class man3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bthienthi = findViewById(R.id.bthienthi);
        bthienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<CanBo> listCB = new ArrayList<>();
                ListView lv = findViewById(R.id.lvcanbo);
                lv.setDivider(null);
                String json = "{\n" +
                        "  \"listCB\": [\n" +
                        "    {\n" +
                        "      \"macb\": \"210000\",\n" +
                        "      \"hoten\": \"Phan Anh Tuấn\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"macb\": \"300000\",\n" +
                        "      \"hoten\": \"Mai Thị Mai\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";

                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray a = object.getJSONArray("listCB");
                    for (int i = 0; i< a.length(); i++) {
                        JSONObject ob = a.getJSONObject(i);
                        CanBo cb= new CanBo(ob.getString("macb"), ob.getString("hoten"));
                        listCB.add(cb);
                    }
                    CanBoAdapter adapter = new CanBoAdapter(man3.this, R.layout.activity_canbo, listCB);
                    lv.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(man3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}