package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Context;
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

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Test;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel.TestViewModel;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    TestViewModel testViewModel;
    Test test;
    EditText editTextTestId;
    EditText editTextTestWeight;
    EditText editTextTestTemperature;
    EditText editTextTestHeartRate;
    EditText editTextTestBPL;
    EditText editTextTestBPH;
    EditText editTextTestNurseId;
    EditText editTextTestPatientId;

    static Context testActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        editTextTestId=(EditText)findViewById(R.id.editTextTestId);
        editTextTestWeight=(EditText)findViewById(R.id.editTextTestWeight);
        editTextTestTemperature=(EditText)findViewById(R.id.editTextTestTemperature);
        editTextTestHeartRate=(EditText)findViewById(R.id.editTextTestHeartRate);
        editTextTestBPL=(EditText)findViewById(R.id.editTextTestBPL);
        editTextTestBPH=(EditText)findViewById(R.id.editTextTestBPH);
        editTextTestNurseId=(EditText)findViewById(R.id.editTextTestNurseId);
        editTextTestPatientId=(EditText)findViewById(R.id.editTextTestPatientId);
        testActivityContext=getApplicationContext();

        final TextView textViewDisplayTests=(TextView)findViewById(R.id.textViewDisplayTests);
        textViewDisplayTests.setMovementMethod(new ScrollingMovementMethod());

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        test =new Test();

        testViewModel.getAllTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(@Nullable List<Test> tests) {
                String output="";
                output=String.format("%-3s %-3s %-3s %-6s %-4s %-3s %-6s %-6s\n",
                        "Tid","Nid","Pid","Weight","Temp","HR","BPL","BPH");
                for(Test test:tests){
                    output+=String.format("%-3s %-3s %-3s %-6s %-4s %-3s %-6s %-6s\n",
                            test.getTestId(),test.getNurseId(),test.getPatientId(),test.getWeight(),
                            test.getTemperature(),test.getHeartRate(),test.getBPL(),test.getBPH());
                }
                textViewDisplayTests.setText(output);
            }
        });

        final Button btnCreateTest=(Button) findViewById(R.id.buttonCreateTest);
        btnCreateTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    test.setWeight(editTextTestWeight.getText().toString());
                    test.setTemperature(editTextTestTemperature.getText().toString());
                    test.setHeartRate(editTextTestHeartRate.getText().toString());
                    test.setBPL(editTextTestBPL.getText().toString());
                    test.setBPH(editTextTestBPH.getText().toString());
                    if(editTextTestNurseId.getText().toString().matches("")){
                        throw new Exception("Nurse Id cannot be empty");
                    }
                    if(editTextTestPatientId.getText().toString().matches("")){
                        throw new Exception("Patient Id cannot be empty");
                    }
                    test.setNurseId(Integer.parseInt(editTextTestNurseId.getText().toString()));
                    test.setPatientId(Integer.parseInt(editTextTestPatientId.getText().toString()));
                    testViewModel.insertTest(test);
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

    public static Context getTestActivityContext(){
        return testActivityContext;
    }
}
