package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;


import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import com.myproyect.gestornovelasnjr.gestor_novelas.DB.NovelDao;
import com.myproyect.gestornovelasnjr.gestor_novelas.DB.NovelDatabase;

import java.util.List;

public class NovelRepository {
    private NovelDao novelDao;
    private LiveData<List<Novel>> allNovels;

    public NovelRepository(Application application) {
        NovelDatabase database = NovelDatabase.getInstance(application);
        novelDao = database.novelDao();
        allNovels = novelDao.getAllNovels();
    }

    public void insert(Novel novel) {
        new InsertNovelAsyncTask(novelDao).execute(novel);
    }

    public void delete(Novel novel) {
        new DeleteNovelAsyncTask(novelDao).execute(novel);
    }

    public void update(Novel novel) {
        new UpdateNovelAsyncTask(novelDao).execute(novel);
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }

    private static class InsertNovelAsyncTask {
        private NovelDao novelDao;

        private InsertNovelAsyncTask(NovelDao novelDao) {
            this.novelDao = novelDao;
        }

        public void execute(Novel novel) {
        }
    }

    private static class DeleteNovelAsyncTask extends AsyncTask<Novel, Void, Void> {
        private NovelDao novelDao;

        private DeleteNovelAsyncTask(NovelDao novelDao) {
            this.novelDao = novelDao;
        }

        @Override
        protected Void doInBackground(Novel... novels) {
            novelDao.delete(novels[0]);
            return null;
        }
    }

    private static class UpdateNovelAsyncTask extends AsyncTask<Novel, Void, Void> {
        private NovelDao novelDao;

        private UpdateNovelAsyncTask(NovelDao novelDao) {
            this.novelDao = novelDao;
        }

        @Override
        protected Void doInBackground(Novel... novels) {
            novelDao.update(novels[0]);
            return null;
        }
    }
}