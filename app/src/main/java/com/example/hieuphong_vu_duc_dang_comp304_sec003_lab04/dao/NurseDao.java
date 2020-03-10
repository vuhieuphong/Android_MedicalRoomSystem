package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Nurse;

import java.util.List;

@Dao
public interface NurseDao {
    @Query("SELECT * FROM nurse")
    List<Nurse> getAll();

    @Query("SELECT * FROM nurse WHERE nurse_id=:nurseId")
    List<Nurse> getById(int nurseId);

    @Insert
    void insertAll(Nurse... nurses);
    @Insert
    void insert(Nurse nurse);

    @Delete
    void delete(Nurse nurse);

    @Update
    void updateAll(Nurse... nurses);
    @Update
    void update(Nurse nurse);
}
