package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Patient;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository.PatientRepository;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private LiveData<Integer> insertPatientResult;
    private LiveData<List<Patient>> allPatients;


    public PatientViewModel(@NonNull Application application){
        super(application);
        patientRepository =new PatientRepository(application);
        //insertPatientResult= patientRepository.getInsertPatientResult();
        allPatients= patientRepository.getAllPatients();
    }

    public void insertPatient(Patient patient){
        patientRepository.insertPatient(patient);
    }

    public void updatePatient(Patient patient){
        patientRepository.updatePatient(patient);
    }

    public void deletePatientById(Integer patientId){
        patientRepository.deletePatientById(patientId);
    }

    //public LiveData<Integer> getInsertPatientResult(){
    //    return insertPatientResult;
    //}

    public LiveData<List<Patient>> getAllPatients(){return allPatients;}

}
