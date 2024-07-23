package com.example.onthiandroid.bai5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class man2_bai5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2_bai5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioButton rbDecaf, rbExp, rbColom;
        CheckBox cbCream, cbSugar;
        Button btPay;
        rbExp = findViewById(R.id.rbExp);
        rbDecaf = findViewById(R.id.rbDecaf);
        rbColom = findViewById(R.id.rbColo);
        cbSugar = findViewById(R.id.cbSugar);
        cbCream = findViewById(R.id.cbCream);
        btPay = findViewById(R.id.btPay);
        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String decaf = rbDecaf.getText().toString();
                String exp = rbExp.getText().toString();
                String colom = rbColom.getText().toString();
                String cream = cbCream.getText().toString();
                String sugar = cbSugar.getText().toString();
                String s1 = "";
                if(rbExp.isChecked()) {
                    s1 = exp;
                } else if(rbDecaf.isChecked()) {
                    s1 = decaf;
                } else {
                    s1 = colom;
                }
                String s2 = "";
                if(cbCream.isChecked()) {
                    s2 += cream + "&";
                }
                if(cbSugar.isChecked()) {
                    s2 += sugar;
                }
                Toast.makeText(man2_bai5.this, s1 + " " + s2, Toast.LENGTH_SHORT).show();
            }
        });
        Button btnext = findViewById(R.id.btnext5);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man2_bai5.this, man3_bai5.class);
                startActivity(in);
            }
        });
    }
}