package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity.PatientActivity;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity.UpdatePatientActivity;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.AppDatabase;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao.PatientDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Patient;

import java.util.List;

public class PatientRepository {
    private PatientDao patientDao;

    //private MutableLiveData<Integer> insertPatientResult=
    //        new MutableLiveData<>();
    private LiveData<List<Patient>> patientsList;

    public PatientRepository(Context context){
        AppDatabase db=AppDatabase.getInstance(context);
        patientDao=db.patientDao();
        patientsList=patientDao.getAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients(){return  patientsList;}
    //public LiveData<Integer> getInsertPatientResult(){return insertPatientResult;}

    public void insertPatient(Patient patient){insertAsync(patient);}
    public void insertAsync(final Patient patient){
        new InsertAsyncTask(patientDao).execute(patient);
    }

    private static class InsertAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao mAsyncPatientDao;
        private boolean valid=true;

        InsertAsyncTask(PatientDao dao) {
            mAsyncPatientDao = dao;
        }

        @Override
        protected Void doInBackground(final Patient... patients) {
            try{
                mAsyncPatientDao.insertPatient(patients[0]);
            }
            catch (Exception e){
                valid=false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            if(valid==false){
                Toast.makeText(PatientActivity.getPatientActivityContext(),"Constraint Not Met",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updatePatient(Patient patient){updateAsync(patient);}
    public void updateAsync(final Patient patient){
        new UpdateAsyncTask(patientDao).execute(patient);
    }

    private static class UpdateAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao mAsyncPatientDao;
        private boolean valid=true;

        UpdateAsyncTask(PatientDao dao) {
            mAsyncPatientDao = dao;
        }

        @Override
        protected Void doInBackground(final Patient... patients) {
            try{
                mAsyncPatientDao.updatePatient(patients[0]);
            }
            catch (Exception e){
                valid=false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            if(valid==false){
                Toast.makeText(UpdatePatientActivity.getUpdatePatientActivityContext(),"Constraint Not Met",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deletePatientById(Integer patientId){deleteAsync(patientId);}
    public void deleteAsync(final Integer patientId){
        new DeleteAsyncTask(patientDao).execute(patientId);
    }

    private static class DeleteAsyncTask extends AsyncTask<Integer, Void, Void> {
        private PatientDao mAsyncPatientDao;
        private boolean valid=true;

        DeleteAsyncTask(PatientDao dao) {
            mAsyncPatientDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... patientIds) {
            try{
                mAsyncPatientDao.deletePatientById(patientIds[0]);
            }
            catch (Exception e){
                valid=false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            if(valid==false){
                Toast.makeText(UpdatePatientActivity.getUpdatePatientActivityContext(),"FK Not Met",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
