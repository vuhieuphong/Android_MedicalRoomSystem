package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Test;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.R;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel.TestViewModel;

import org.w3c.dom.Text;

public class ViewTestActivity extends AppCompatActivity {
    TestViewModel testViewModel;
    Test test;
    EditText editTextTestId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtest);
        editTextTestId=(EditText)findViewById(R.id.editTextTestId);

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        test=new Test();

        final Button btnSearchTest = (Button) findViewById(R.id.buttonSearchTest);
        final TextView textViewTestDetails=(TextView)findViewById(R.id.textViewDisplayTestDetails);

        btnSearchTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Integer testIdEntered=Integer.parseInt(editTextTestId.getText().toString());
                    Test testById=testViewModel.getTestById(testIdEntered);
                    if(testById!=null){
                        textViewTestDetails.setText("");
                        textViewTestDetails.setText("Test Id: "+testById.getTestId()+"\n");
                        textViewTestDetails.append("Weight: "+testById.getWeight()+"\n");
                        textViewTestDetails.append("Temperature: "+testById.getTemperature()+"\n");
                        textViewTestDetails.append("Heart Rate: "+testById.getHeartRate()+"\n");
                        textViewTestDetails.append("BPL: "+testById.getBPL()+"\n");
                        textViewTestDetails.append("Test Id: "+testById.getBPH()+"\n");
                        textViewTestDetails.append("Nurse Id: "+testById.getNurseId()+"\n");
                        textViewTestDetails.append("Patient Id: "+testById.getPatientId()+"\n");
                    }
                    else {
                        textViewTestDetails.setText("");
                        Toast.makeText(getApplicationContext(),"Invalid Test Id",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    textViewTestDetails.setText("");
                    Toast.makeText(getApplicationContext(),"Invalid Test Id",Toast.LENGTH_SHORT).show();
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
}
