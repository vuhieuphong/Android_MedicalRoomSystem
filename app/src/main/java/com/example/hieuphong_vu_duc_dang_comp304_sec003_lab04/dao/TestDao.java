package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.entities.Test;

import java.util.List;

@Dao
public interface TestDao {
    @Query("SELECT * FROM test")
    List<Test> getAll();

    @Query("SELECT * FROM test WHERE test_id=:testId")
    List<Test> getById(int testId);

    @Insert
    void insertAll(Test... tests);
    @Insert
    void insert(Test test);

    @Delete
    void delete(Test test);

    @Update
    void updateAll(Test... tests);
    @Update
    void update(Test test);
}
