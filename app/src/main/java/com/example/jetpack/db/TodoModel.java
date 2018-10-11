package com.example.jetpack.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoModel {
    @PrimaryKey(autoGenerate = true)
    public int mId;

    private String mTitle;

    public TodoModel(String title) {
        this.mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
}
