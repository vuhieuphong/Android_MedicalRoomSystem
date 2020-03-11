package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.AppDatabase;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao.NurseDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;

import java.util.List;

public class NurseRepository {
    private NurseDao nurseDao;
    private MutableLiveData<Integer> insertNurseResult=
            new MutableLiveData<>();
    private LiveData<List<Nurse>> nursesList;
    private LiveData<Nurse> nurseByIdAndPassword;
    public NurseRepository(Context context){
        AppDatabase db=AppDatabase.getInstance(context);
        nurseDao=db.nurseDao();
        nursesList=nurseDao.getAllNurses();
    }

    public LiveData<List<Nurse>> getAllNurses(){return  nursesList;}
    public LiveData<Nurse> getNurseByIdAndPassword(){return nurseByIdAndPassword;}
    public LiveData<Integer> getInsertNurseResult(){return insertNurseResult;}

    public void insertNurse(Nurse nurse){nurseDao.insertNurse(nurse);}


}

