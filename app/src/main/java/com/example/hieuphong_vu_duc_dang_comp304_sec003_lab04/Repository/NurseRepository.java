package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository;

import android.content.Context;
import android.os.AsyncTask;

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
    private LiveData<Integer> lastNurseId;

    public NurseRepository(Context context){
        AppDatabase db=AppDatabase.getInstance(context);
        nurseDao=db.nurseDao();
        nursesList=nurseDao.getAllNurses();
        lastNurseId=nurseDao.getLastNurseId();
    }

    public LiveData<List<Nurse>> getAllNurses(){return  nursesList;}
    public LiveData<Integer> getInsertNurseResult(){return insertNurseResult;}
    public LiveData<Integer> getLastNurseId(){return lastNurseId;}

    public void insertNurse(Nurse nurse){insertAsync(nurse);}

    public void insertAsync(final Nurse nurse){
        new InsertAsyncTask(nurseDao).execute(nurse);
    }

    private static class InsertAsyncTask extends AsyncTask<Nurse, Void, Void> {
        private NurseDao mAsyncNurseDao;

        InsertAsyncTask(NurseDao dao) {
            mAsyncNurseDao = dao;
        }

        @Override
        protected Void doInBackground(final Nurse... nurses) {
            mAsyncNurseDao.insertNurse(nurses[0]);
            return null;
        }
    }
}




