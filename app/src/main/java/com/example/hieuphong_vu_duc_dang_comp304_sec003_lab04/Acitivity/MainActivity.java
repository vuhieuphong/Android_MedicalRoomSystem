package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btnLogout=(ImageButton)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivity=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
