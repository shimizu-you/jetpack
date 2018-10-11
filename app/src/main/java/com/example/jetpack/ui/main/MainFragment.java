package com.example.jetpack.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jetpack.R;
import com.example.jetpack.db.TodoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainFragment extends Fragment {
    private MainViewModel mViewModel;
    private MainAdapter mMainAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainAdapter = new MainAdapter(onListener);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getAllTodo().observe(this, new Observer<List<TodoModel>>() {
            @Override
            public void onChanged(@Nullable final List<TodoModel> todoList) {
                mMainAdapter.setTodoList(todoList);
            }
        });

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mMainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.todoFragment);
            }
        });
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private OnListSelectedListener onListener = new OnListSelectedListener() {
        @Override
        public void onListSelected(TodoModel todo) {
            if (todo != null) {
MainFragmentDirections
            }
        }
    };

    public interface OnListSelectedListener {
        void onListSelected(TodoModel todo);
    }
}
