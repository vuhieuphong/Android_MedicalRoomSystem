package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;

import java.util.List;

@Dao
public interface NurseDao {
    @Insert
    void insertNurse(Nurse nurse);

    @Query("select * from nurse")
    LiveData<List<Nurse>> getAllNurses();

    @Query("select * from nurse where nurseId=:nurse_id and password=:pass")
    Nurse getNurseByIdPass(int nurse_id,String pass);
}
