package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Patient {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "patient_id")
    public int patientId;
    @ColumnInfo(name = "first_name")
    public String firstname;
    @ColumnInfo(name = "last_name")
    public String lastname;
    public String department;

    //referenece key??
    @ColumnInfo(name = "nurse_id")
    public int nurseId;
    public String room;

}
