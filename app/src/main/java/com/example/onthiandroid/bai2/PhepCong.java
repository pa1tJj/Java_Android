package com.example.onthiandroid.bai2;

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

public class PhepCong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phep_cong);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtSoA = findViewById(R.id.txtSoA);
        EditText txtSoB = findViewById(R.id.txtSoB);
        Button btCong = findViewById(R.id.btCong);
        TextView tvKetQua = findViewById(R.id.tvKetQua);
        btCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(txtSoA.getText().toString());
                double b = Double.parseDouble(txtSoB.getText().toString());
                double tong = 0;
                tong = a + b;
                tvKetQua.setText("Kết quả phép cộng là:" + tong);
            }
        });
    }
}