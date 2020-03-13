package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    void insertPatient(Patient patient);

    @Query("select * from patient")
    LiveData<List<Patient>> getAllPatients();

    @Query("select max(patientId) from patient")
    LiveData<Integer> getLastPatientId();
}
