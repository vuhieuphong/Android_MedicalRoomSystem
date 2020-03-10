package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "test_id")
    public int testId;

    @ColumnInfo(name = "patient_id")
    public int patientId;

    @ColumnInfo(name = "nurse_id")
    public int nurseId;

    public String bpl;
    public String bph;
    public String temperature;
}
