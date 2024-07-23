package com.example.onthiandroid.bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

import java.util.ArrayList;
import java.util.List;

public class man4_bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man4_bai4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtNhapten = findViewById(R.id.txtNhapTen4);
        Button btNhap = findViewById(R.id.btnhap4);
        ListView lv = findViewById(R.id.lvMonHoc);
        List<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(man4_bai4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtNhapten.getText().toString();
                list.add(ten);
                lv.setAdapter(adapter);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(man4_bai4.this, list.set(i, txtNhapten.getText().toString()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}