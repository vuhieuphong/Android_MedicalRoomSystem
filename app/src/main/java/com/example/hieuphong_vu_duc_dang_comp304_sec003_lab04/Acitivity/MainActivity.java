package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        Toast.makeText(getApplicationContext(),"Welcome "+prf.getString("name",null),Toast.LENGTH_SHORT)
                .show();

        final ImageButton btnLogout=(ImageButton)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear shared preference
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();

                Intent loginActivity=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
