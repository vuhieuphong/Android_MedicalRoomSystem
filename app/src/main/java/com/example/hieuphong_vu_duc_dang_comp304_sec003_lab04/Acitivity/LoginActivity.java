package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel.NurseViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    NurseViewModel nurseViewModel;
    Nurse nurse;
    EditText editTextLoginNurseId;
    EditText editTextLoginPassword;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextLoginNurseId=(EditText)findViewById(R.id.editTextLoginNurseId);
        editTextLoginPassword=(EditText)findViewById(R.id.editTextLoginPassword);

        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);
        nurse=new Nurse();

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        if(pref.contains("id") && pref.contains("password")){
            Toast.makeText(getApplicationContext(),"Welcome "+pref.getString("name",null),Toast.LENGTH_SHORT)
                    .show();
            Intent mainActivity=new Intent(this,MainActivity.class);
            startActivity(mainActivity);
        }

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Integer loginId=Integer.parseInt(editTextLoginNurseId.getText().toString());
                    String loginPass=editTextLoginPassword.getText().toString();
                    Nurse nurseByIdPass=nurseViewModel.getNurseByIdPass(loginId,loginPass);
                    if(nurseByIdPass!=null){
                        //saving into shared preference
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("id",loginId);
                        editor.putString("password",loginPass);
                        editor.putString("name",nurseByIdPass.getFName()+" "+nurseByIdPass.getLName());
                        editor.commit();

                        Toast.makeText(getApplicationContext(),"Welcome "+pref.getString("name",null),Toast.LENGTH_SHORT)
                                .show();

                        Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(mainActivity);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
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
