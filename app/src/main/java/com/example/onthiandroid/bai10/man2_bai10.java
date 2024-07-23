package com.example.onthiandroid.bai10;

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

public class man2_bai10 extends AppCompatActivity {

    int viTri = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2_bai10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<String> list = new ArrayList<>();
        ListView lv = findViewById(R.id.lvItem);
        Button btthem, btsua, bttim, btxoa;
        btsua = findViewById(R.id.btsua);
        btthem = findViewById(R.id.btthem);
        bttim = findViewById(R.id.bttk);
        btxoa = findViewById(R.id.btxoa);
        EditText txtnhap = findViewById(R.id.txtnhap);
        ArrayAdapter adapter = new ArrayAdapter(man2_bai10.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viTri = i;
                txtnhap.setText(list.get(i));
            }
        });
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(txtnhap.getText().toString());
                lv.setAdapter(adapter);
            }
        });

        btsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = txtnhap.getText().toString();
                list.set(viTri, s);
                lv.setAdapter(adapter);
            }
        });

        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(viTri);
                lv.setAdapter(adapter);
            }
        });

        bttim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String s : list) {
                    if(s.equals(txtnhap.getText().toString())) {
                        Toast.makeText(man2_bai10.this, "tìm thấy", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(man2_bai10.this, "không tìm thấy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}