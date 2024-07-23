package com.example.onthiandroid.bai9;

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

public class man2_bai9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2_bai9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.lvBaiToan9);
        Button btOk, btExit;
        btOk = findViewById(R.id.btOK);
        btExit = findViewById(R.id.btexit9);
        List<String> list = new ArrayList<>();
        list.add("Thương 2 số");
        list.add("Tổng 2 số");
        list.add("Nghe nhạc");
        list.add("Tạo hình");
        list.add("Phân tích JSON");
        ArrayAdapter adapter = new ArrayAdapter(man2_bai9.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        lv.setAdapter(adapter);
        int []pos = {-1};
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos[0] = i;
            }
        });
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos[0] == 0) {
                    Intent in = new Intent(man2_bai9.this, Thuong2So.class);
                    startActivity(in);
                } else if(pos[0] == 4) {
                    Intent in = new Intent(man2_bai9.this, man4_bai9.class);
                    startActivity(in);
                }
            }
        });
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