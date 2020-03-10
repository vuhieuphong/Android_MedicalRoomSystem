package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "nurse_id")
    public int nurseId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    public String department;
    public String password;
}
