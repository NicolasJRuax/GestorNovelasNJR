package com.myproyect.gestornovelasnjr.gestor_novelas.DB;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.myproyect.gestornovelasnjr.gestor_novelas.Novelas.Novel;

import java.util.List;

@Dao
public interface NovelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Novel novel);

    @Delete
    void delete(Novel novel);

    @Update
    void update(Novel novel);

    @Query("SELECT * FROM novel_table ORDER BY id ASC")
    LiveData<List<Novel>> getAllNovels();
}