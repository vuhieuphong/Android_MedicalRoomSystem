package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository.NurseRepository;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    private NurseRepository nurseRepository;
    private LiveData<Integer> insertNurseResult;
    private LiveData<List<Nurse>> allNurses;
    private LiveData<Integer> lastNurseId;


    public NurseViewModel(@NonNull Application application){
        super(application);
        nurseRepository=new NurseRepository(application);
        insertNurseResult=nurseRepository.getInsertNurseResult();
        allNurses=nurseRepository.getAllNurses();
        lastNurseId=nurseRepository.getLastNurseId();
    }

    public void insertNurse(Nurse nurse){
        nurseRepository.insertNurse(nurse);
    }

    public LiveData<Integer> getInsertNurseResult(){
        return insertNurseResult;
    }

    public LiveData<List<Nurse>> getAllNurses(){return allNurses;}

    public LiveData<Integer> getLastNurseId(){return lastNurseId;}

    public Nurse getNurseByIdPass(int nurse_id, String pass){return nurseRepository.getNurseByIdPass(nurse_id,pass);}

}
