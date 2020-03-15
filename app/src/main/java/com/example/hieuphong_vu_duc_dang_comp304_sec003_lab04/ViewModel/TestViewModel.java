package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Test;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository.TestRepository;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    private TestRepository testRepository;
    private LiveData<List<Test>> allTests;


    public TestViewModel(@NonNull Application application){
        super(application);
        testRepository =new TestRepository(application);
        allTests= testRepository.getAllTests();
    }

    public void insertTest(Test test){
        testRepository.insertTest(test);
    }

    public LiveData<List<Test>> getAllTests(){return allTests;}

    public Test getTestById(int test_id){return testRepository.getTestById(test_id);}
}
