package com.example.onthiandroid.bai7;

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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class man4_bai7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man4_bai7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bthienthi = findViewById(R.id.bthienthi7);
        ListView lv = findViewById(R.id.lvCongNhan);
        List<String> list = new ArrayList<>();
        bthienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "  \"CongNhan\": [\n" +
                        "    {\n" +
                        "      \"id\": \"123\",\n" +
                        "      \"ten\": \"phan anh tuấn\",\n" +
                        "      \"luong\": 21424,\n" +
                        "      \"gioitinh\": \"nam\",\n" +
                        "      \"chucvu\": \"trưởng phòng\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"456\",\n" +
                        "      \"ten\": \"mai thị mai\",\n" +
                        "      \"luong\": 54364,\n" +
                        "      \"gioitinh\": \"nam\",\n" +
                        "      \"chucvu\": \"giám đốc\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"789\",\n" +
                        "      \"ten\": \"đinh tiên hoàng\",\n" +
                        "      \"luong\": 23646,\n" +
                        "      \"gioitinh\": \"nam\",\n" +
                        "      \"chucvu\": \"phó giám đốc\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray a = jsonObject.getJSONArray("CongNhan");
                    for (int i = 0; i < a.length(); i++) {
                        JSONObject ob = a.getJSONObject(i);
                        String s = ob.getString("id") + "\n" + ob.getString("ten") + "\n" + ob.getDouble("luong") + "\n" + ob.getString("gioitinh") + "\n" + ob.getString("chucvu");
                        list.add(s);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(man4_bai7.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    lv.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}