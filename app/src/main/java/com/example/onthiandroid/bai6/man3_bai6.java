package com.example.onthiandroid.bai6;

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
import com.example.onthiandroid.bai4.man4_bai4;

import java.util.ArrayList;
import java.util.List;

public class man3_bai6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man3_bai6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lv = findViewById(R.id.lvQua);
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Litchi");
        list.add("Mango");
        ArrayAdapter adapter = new ArrayAdapter(man3_bai6.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(man3_bai6.this, list.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnext = findViewById(R.id.btnext61);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man3_bai6.this, man4_bai6.class);
                startActivity(in);
            }
        });
    }
}