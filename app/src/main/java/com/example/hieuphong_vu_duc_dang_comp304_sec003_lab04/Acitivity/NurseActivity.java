package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel.NurseViewModel;

import java.util.List;

public class NurseActivity extends AppCompatActivity {

    NurseViewModel nurseViewModel;
    Nurse nurse;
    EditText editTextNurseId;
    EditText editTextFName;
    EditText editTextLName;
    EditText editTextDepartment;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
        editTextNurseId=(EditText)findViewById(R.id.editTextNurseId);
        editTextFName=(EditText)findViewById(R.id.editTextNurseFname);
        editTextLName=(EditText)findViewById(R.id.editTextNurseLname);
        editTextDepartment=(EditText)findViewById(R.id.editTextNurseDepartment);
        editTextPassword=(EditText)findViewById(R.id.editTextNursePassword);

        final TextView textViewDisplayNurses=(TextView)findViewById(R.id.textViewDisplayNurses);
        textViewDisplayNurses.setMovementMethod(new ScrollingMovementMethod());

        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);
        nurse=new Nurse();


        /*not working:
        nurseViewModel.getInsertNurseResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {

                if(result==1){
                    Toast.makeText(getApplicationContext(),"New Nurse Created",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error Creating Nurse",Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        nurseViewModel.getAllNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(@Nullable List<Nurse> nurses) {
                String output="";
                output=String.format("%-3s %-8s %-8s %-8s %-8s\n","Nid","Password","FName","LName","Department");
                for(Nurse nurse:nurses){
                    output+=String.format("%-3s %-8s %-8s %-8s %-8s\n"
                            ,nurse.getNurseId(),nurse.getPassword(),nurse.getFName(),nurse.getLName(),nurse.getDepartment());
                }
                textViewDisplayNurses.setText(output);
            }
        });

        final Button btnCreateNurse=(Button) findViewById(R.id.buttonCreateNurse);
        btnCreateNurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nurse.setFName(editTextFName.getText().toString());
                    nurse.setLName(editTextLName.getText().toString());
                    nurse.setDepartment(editTextDepartment.getText().toString());
                    if(editTextPassword.getText().toString().matches("")){
                        throw new Exception("Password cannot be empty");
                    }
                    nurse.setPassword(editTextPassword.getText().toString());
                    nurseViewModel.insertNurse(nurse);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });


        final Button btnReturn=(Button) findViewById(R.id.buttonReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivity=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
