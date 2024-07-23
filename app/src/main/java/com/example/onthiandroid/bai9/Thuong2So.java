package com.example.onthiandroid.bai9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class Thuong2So extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thuong2_so);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtso1 = findViewById(R.id.txtSoa);
        EditText txtso2 = findViewById(R.id.txtSob);
        TextView tvkq = findViewById(R.id.tvketqua);
        Button btKQ, btBack;
        btKQ = findViewById(R.id.btketqua);
        btBack = findViewById(R.id.btBack);
        btKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(txtso1.getText().toString());
                double b = Double.parseDouble(txtso2.getText().toString());
                double kq = 0;
                if(b == 0) {
                    Toast.makeText(Thuong2So.this, "Không thực hiện được vì mẫu số phải khác 0", Toast.LENGTH_SHORT).show();
                } else{
                    kq = a / b;
                    tvkq.setText("Thương 2 số là:" + kq);
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Thuong2So.this, man2_bai9.class);
                startActivity(in);
            }
        });
    }
}