package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.AppDatabase;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao.NurseDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Nurse;

import java.lang.ref.WeakReference;
import java.util.List;

public class NurseRepository {
    private NurseDao nurseDao;
    //private MutableLiveData<Integer> insertNurseResult=
    //        new MutableLiveData<>();
    private LiveData<List<Nurse>> nursesList;

    public NurseRepository(Context context){
        AppDatabase db=AppDatabase.getInstance(context);
        nurseDao=db.nurseDao();
        nursesList=nurseDao.getAllNurses();
    }

    public LiveData<List<Nurse>> getAllNurses(){return  nursesList;}
    //public LiveData<Integer> getInsertNurseResult(){return insertNurseResult;}

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

    public Nurse getNurseByIdPass(int nurse_id, String pass){
        Nurse nurseByIdPass=null;
        try {
             nurseByIdPass=new CheckCredentialsAsync(nurseDao,nurse_id,pass).execute().get();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return nurseByIdPass;
    }

    private static class CheckCredentialsAsync extends AsyncTask<Void, Void, Nurse> {
        private NurseDao mAsyncNurseDao;
        private Integer loginId;
        private String loginPass;

        CheckCredentialsAsync(NurseDao dao,Integer loginId,String loginPass) {
            mAsyncNurseDao = dao;
            this.loginId=loginId;
            this.loginPass=loginPass;
        }

        @Override
        protected Nurse doInBackground(final Void... voids) {
            return mAsyncNurseDao.getNurseByIdPass(loginId,loginPass);
        }

        @Override
        protected void onPostExecute(Nurse nurse) {
            super.onPostExecute(nurse);
        }
    }
}




