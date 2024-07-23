package com.example.onthiandroid.bai3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

import java.util.ArrayList;
import java.util.List;

public class man3_bai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man3_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtNhapTen = findViewById(R.id.txtNhapTen);
        Button btNhap = findViewById(R.id.btnhap);
        ListView lv = findViewById(R.id.lvTen);
        List<String> listTen = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(man3_bai3.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listTen);
        lv.setAdapter(adapter);

        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtNhapTen.getText().toString();
                listTen.add(ten);
                lv.setAdapter(adapter);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listTen.remove(i);
                lv.setAdapter(adapter);
                return true;
            }
        });

        TextView tvHienThi = findViewById(R.id.tvHienThi);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ten = txtNhapTen.getText().toString();
                String s = (i + 1) + "-" + listTen.set(i, ten);
                //hàm set(pos, đối tượng) trả về đối tượng ở vị trí pos
                tvHienThi.setText(s);
            }
        });

    }
}