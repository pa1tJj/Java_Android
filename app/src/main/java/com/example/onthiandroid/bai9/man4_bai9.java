package com.example.onthiandroid.bai9;

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

public class man4_bai9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man4_bai9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.lvNguoi);
        Button bthien = findViewById(R.id.bthienthi9);
        List<String> list = new ArrayList<>();
        bthien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "  \"Nguoi\": [\n" +
                        "    {\n" +
                        "      \"id\": \"123\",\n" +
                        "      \"name\": \"phan anh tuấn\",\n" +
                        "      \"email\": \"pat@gmail.com\",\n" +
                        "      \"gender\": \"nam\",\n" +
                        "      \"mobile\": \"02856439\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"345\",\n" +
                        "      \"name\": \"Mai Thị Mai\",\n" +
                        "      \"email\": \"mtm@gmail.com\",\n" +
                        "      \"gender\": \"nữ\",\n" +
                        "      \"mobile\": \"03258435\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"789\",\n" +
                        "      \"name\": \"Đinh Tiên Hoàng\",\n" +
                        "      \"email\": \"dth@gmail.com\",\n" +
                        "      \"gender\": \"nam\",\n" +
                        "      \"mobile\": \"099999999\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray a = jsonObject.getJSONArray("Nguoi");
                    for (int i = 0; i < a.length(); i++) {
                        JSONObject ob = a.getJSONObject(i);
                        String s = ob.getString("id") + "-" + ob.getString("name") + "-" + ob.getString("email") + "-" + ob.getString("gender") + "-" + ob.getString("mobile");
                        list.add(s);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(man4_bai9.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    lv.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}