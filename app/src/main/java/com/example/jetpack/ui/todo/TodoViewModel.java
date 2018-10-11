package com.example.jetpack.ui.todo;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.jetpack.db.TodoDatabase;
import com.example.jetpack.db.TodoModel;
import com.example.jetpack.db.TodoModelDao;
import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoDatabase mTodoDatabase;
    private LiveData<List<TodoModel>> mTodoList;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        mTodoDatabase = TodoDatabase.getDatabase(application);
        mTodoList = mTodoDatabase.getDao().getAllTodo();
    }

    public void insertTodo(String title) {
        TodoModel todo = new TodoModel(title);
        new insertTask(mTodoDatabase.getDao()).execute(todo);
    }

    private class insertTask extends AsyncTask<TodoModel, Void, Void> {
        private TodoModelDao mAsyncTaskDao;

        insertTask(TodoModelDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TodoModel... params) {
            mAsyncTaskDao.insertTodo(params[0]);
            return null;
        }
    }
}
