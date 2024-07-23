package com.example.onthiandroid.bai10;

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
import com.example.onthiandroid.bai9.dang_nhap9;
import com.example.onthiandroid.bai9.man2_bai9;

public class dang_nhap10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtuser = findViewById(R.id.txtuser10);
        EditText txtpass = findViewById(R.id.txtpass10);
        Button btLogin = findViewById(R.id.btlogin10);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtuser.getText().toString();
                String pass = txtpass.getText().toString();
                if(user.equals("admin") && pass.equals("123")) {
                    Intent in = new Intent(dang_nhap10.this, man2_bai10.class);
                    startActivity(in);
                } else if(user.equals("")) {
                    Toast.makeText(dang_nhap10.this, "chưa nhập tên", Toast.LENGTH_SHORT).show();
                } else if(pass.equals("")) {
                    Toast.makeText(dang_nhap10.this, "chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else if(!user.equals("admin")) {
                    Toast.makeText(dang_nhap10.this, "nhập sai tên", Toast.LENGTH_SHORT).show();
                } else if(!pass.equals("123")) {
                    Toast.makeText(dang_nhap10.this, "nhập sai mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}