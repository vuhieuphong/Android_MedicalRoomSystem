package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
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

        final ImageButton btnPatient=(ImageButton)findViewById(R.id.btnPatient);
        btnPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patientActivity=new Intent(getApplicationContext(),PatientActivity.class);
                startActivity(patientActivity);
            }
        });

        final ImageButton btnUpdatePatient=(ImageButton)findViewById(R.id.btnUpdatePatientInfo);
        btnUpdatePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updatePatientActivity=new Intent(getApplicationContext(),UpdatePatientActivity.class);
                startActivity(updatePatientActivity);
            }
        });

        final ImageButton btnTest=(ImageButton)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testActivity=new Intent(getApplicationContext(),TestActivity.class);
                startActivity(testActivity);
            }
        });

        final ImageButton btnViewTest=(ImageButton)findViewById(R.id.btnViewTestInfo);
        btnViewTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewTestActivity=new Intent(getApplicationContext(),ViewTestActivity.class);
                startActivity(viewTestActivity);
            }
        });
    }
}
