package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Test;

import java.util.List;

@Dao
public interface TestDao {
    @Insert
    void insertTest(Test test);

    @Query("select * from test")
    LiveData<List<Test>> getAllTests();

    @Query("select * from test where testId=:test_id")
    Test getTestById(Integer test_id);
}
