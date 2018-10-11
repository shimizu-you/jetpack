package com.example.jetpack.ui.main;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.jetpack.db.TodoDatabase;
import com.example.jetpack.db.TodoModel;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveData<List<TodoModel>> mTodoList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        TodoDatabase db = TodoDatabase.getDatabase(application);
        mTodoList = db.getDao().getAllTodo();
    }

    public LiveData<List<TodoModel>> getAllTodo() {
        return mTodoList;
    }
}
