package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        final Button btnNewNurse=(Button)findViewById(R.id.btnNewNurse);
        btnNewNurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nurseActivity = new Intent(getApplicationContext(), NurseActivity.class);
                startActivity(nurseActivity);
            }
        });
    }
}
