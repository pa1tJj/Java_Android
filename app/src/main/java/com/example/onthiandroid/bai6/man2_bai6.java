package com.example.onthiandroid.bai6;

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
import com.example.onthiandroid.bai5.man2_bai5;
import com.example.onthiandroid.bai5.man3_bai5;

public class man2_bai6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2_bai6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioButton rbDecaf, rbExp, rbColom;
        CheckBox cbCream, cbSugar;
        Button btPay;
        rbExp = findViewById(R.id.rbExp6);
        rbDecaf = findViewById(R.id.rbDecaf6);
        rbColom = findViewById(R.id.rbColo6);
        cbSugar = findViewById(R.id.cbSugar6);
        cbCream = findViewById(R.id.cbCream6);
        btPay = findViewById(R.id.btPay6);
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
                Toast.makeText(man2_bai6.this, s1 + " " + s2, Toast.LENGTH_SHORT).show();
            }
        });
        Button btnext = findViewById(R.id.btnext6);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(man2_bai6.this, man3_bai6.class);
                startActivity(in);
            }
        });
    }
}