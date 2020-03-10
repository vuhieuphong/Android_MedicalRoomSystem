package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Query("SELECT * FROM patient")
    List<Patient> getAll();

    @Query("SELECT * FROM patient WHERE nurse_id=:patientId")
    List<Patient> getById(int patientId);

    @Insert
    void insertAll(Patient... patients);
    @Insert
    void insert(Patient patient);

    @Delete
    void delete(Patient patient);

    @Update
    void updateAll(Patient... patients);
    @Update
    void update(Patient patient);
}
