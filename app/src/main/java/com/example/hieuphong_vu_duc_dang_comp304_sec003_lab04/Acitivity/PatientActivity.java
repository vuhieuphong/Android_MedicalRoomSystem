package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Patient;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel.PatientViewModel;

import java.util.List;

public class PatientActivity extends AppCompatActivity {
    PatientViewModel patientViewModel;
    Patient patient;
    EditText editTextPatientId;
    EditText editTextFName;
    EditText editTextLName;
    EditText editTextDepartment;
    EditText editTextRoom;
    EditText editTextPatientNurseId;

    static Context patientActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        editTextPatientId=(EditText)findViewById(R.id.editTextPatientId);
        editTextFName=(EditText)findViewById(R.id.editTextPatientFname);
        editTextLName=(EditText)findViewById(R.id.editTextPatientLname);
        editTextDepartment=(EditText)findViewById(R.id.editTextPatientDepartment);
        editTextRoom=(EditText)findViewById(R.id.editTextPatientRoom);
        editTextPatientNurseId=(EditText)findViewById(R.id.editTextPatientNurseId);
        patientActivityContext=getApplicationContext();

        final TextView textViewDisplayPatients=(TextView)findViewById(R.id.textViewDisplayPatients);

        patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);
        patient =new Patient();

        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                String output="";
                for(Patient patient:patients){
                    output+="Patient Id: "+patient.getPatientId()+" - FName: "+patient.getFName()+" - Nurse Id: "+patient.getNurseId()+"\n";
                }
                textViewDisplayPatients.setText(output);
            }
        });


        final Button btnCreatePatient=(Button) findViewById(R.id.buttonCreatePatient);
        btnCreatePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    patient.setFName(editTextFName.getText().toString());
                    patient.setLName(editTextLName.getText().toString());
                    patient.setDepartment(editTextDepartment.getText().toString());
                    patient.setRoom(editTextRoom.getText().toString());
                    if(editTextPatientNurseId.getText().toString().matches("")){
                        throw new Exception("Nurse Id cannot be empty");
                    }
                    patient.setNurseId(Integer.parseInt(editTextPatientNurseId.getText().toString()));
                    patientViewModel.insertPatient(patient);
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
                Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }

    public static Context getPatientActivityContext(){
        return patientActivityContext;
    }
}
