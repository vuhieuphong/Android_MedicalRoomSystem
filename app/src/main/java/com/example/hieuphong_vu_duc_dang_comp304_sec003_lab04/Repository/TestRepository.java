package com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Acitivity.TestActivity;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.AppDatabase;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Dao.TestDao;
import com.example.hieuphong_vu_duc_dang_comp304_sec003_lab04.Entity.Test;

import java.util.List;

public class TestRepository {
    private TestDao testDao;

    private LiveData<List<Test>> testsList;

    public TestRepository(Context context){
        AppDatabase db=AppDatabase.getInstance(context);
        testDao=db.testDao();
        testsList=testDao.getAllTests();
    }

    public LiveData<List<Test>> getAllTests(){return  testsList;}

    public void insertTest(Test test){insertAsync(test);}
    public void insertAsync(final Test test){
        new TestRepository.InsertAsyncTask(testDao).execute(test);
    }

    private static class InsertAsyncTask extends AsyncTask<Test, Void, Void> {
        private TestDao mAsyncTestDao;
        private boolean valid = true;

        InsertAsyncTask(TestDao dao) {
            mAsyncTestDao = dao;
        }

        @Override
        protected Void doInBackground(final Test... tests) {
            try {
                mAsyncTestDao.insertTest(tests[0]);
            } catch (Exception e) {
                valid = false;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            if(valid==false){
                Toast.makeText(TestActivity.getTestActivityContext(),"Constraint Not Met",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public Test getTestById(int test_id){
        Test testById=null;
        try {
            testById=new SearchTestAsync(testDao,test_id).execute().get();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return testById;
    }

    private static class SearchTestAsync extends AsyncTask<Void, Void, Test> {
        private TestDao mAsyncTestDao;
        private Integer testId;

        SearchTestAsync(TestDao dao,Integer testId) {
            mAsyncTestDao = dao;
            this.testId=testId;
        }

        @Override
        protected Test doInBackground(final Void... voids) {
            return mAsyncTestDao.getTestById(testId);
        }
    }
}
