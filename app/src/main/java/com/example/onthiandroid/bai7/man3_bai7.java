package com.example.onthiandroid.bai7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

import java.util.ArrayList;
import java.util.List;

public class man3_bai7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man3_bai7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Litchi");
        list.add("Mango");
        ArrayAdapter adapter = new ArrayAdapter(man3_bai7.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        ListView lv = findViewById(R.id.lvQua7);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                lv.setAdapter(adapter);
            }
        });

        Button btnext = findViewById(R.id.btnext7);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man3_bai7.this, man4_bai7.class);
                startActivity(in);
            }
        });
    }
}