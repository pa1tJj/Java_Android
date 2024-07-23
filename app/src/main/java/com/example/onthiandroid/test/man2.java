package com.example.onthiandroid.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onthiandroid.R;

public class man2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtemail = findViewById(R.id.txtemail);
        EditText txtpass = findViewById(R.id.txtpass);
        Button btNe = findViewById(R.id.btnext);
        btNe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtemail.getText().toString();
                String pass = txtpass.getText().toString();
                if(pass.length() >= 6) {
                    Intent in = new Intent(man2.this, man3.class);
                    startActivity(in);
                } else {
                    Toast.makeText(man2.this, "Cách nhập email không đúng hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}