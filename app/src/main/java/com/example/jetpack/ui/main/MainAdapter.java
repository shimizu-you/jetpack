package com.example.jetpack.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jetpack.R;
import com.example.jetpack.db.TodoModel;
import com.example.jetpack.ui.main.MainFragment.OnListSelectedListener;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<TodoModel> mTodoList;
    private OnListSelectedListener mListener;

    public MainAdapter(OnListSelectedListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mTodoList != null) {
            holder.mTodo = mTodoList.get(position);
            holder.mTitle.setText(holder.mTodo.getTitle());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.onListSelected(holder.mTodo);
                    }
                }
            });
        } else {
            holder.mTitle.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if (mTodoList != null) {
            return mTodoList.size();
        }

        return 0;
    }

    public void setTodoList(List<TodoModel> todoList) {
        mTodoList = todoList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mTitle;
        private TodoModel mTodo;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mTitle = (TextView) view.findViewById(R.id.item_title);
        }
    }
}
