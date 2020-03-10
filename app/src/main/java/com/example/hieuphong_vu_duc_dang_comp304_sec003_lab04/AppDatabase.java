package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao.NurseDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao.PatientDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao.TestDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Nurse;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Patient;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Test;

@Database(entities = {Nurse.class, Patient.class, Test.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NurseDao userDao();
    public abstract PatientDao patientDao();
    public abstract TestDao testDao();
}
