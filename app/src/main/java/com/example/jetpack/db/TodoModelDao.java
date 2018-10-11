package com.example.jetpack.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface TodoModelDao {
    @Query("select * from TodoModel")
    LiveData<List<TodoModel>> getAllTodo();

    @Query("select * from TodoModel where mId = :id")
    LiveData<TodoModel> getTodo(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodo(TodoModel todoModel);

    @Update
    void updateTodo(TodoModel... users);
}
