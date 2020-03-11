package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse {
    @PrimaryKey(autoGenerate = true)
    private int nurseId;
    private String fName;
    private String lName;
    private String department;
    private String password;

    public int getNurseId() {
        return nurseId;
    }
}
