package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public static TaskRepository sInstance;

    private List<Task> mTasks;
    private static String mUserName;
    private static int mNumber;

    public static TaskRepository getInstance(){
        if(sInstance == null)
            sInstance = new TaskRepository();

        return sInstance;
    }

    private TaskRepository(){
        mTasks = new ArrayList<>();
    }

    public void setDetail(String userName , int number){
        mUserName = userName;
        mNumber = number;

        for (int i = 0; i < mNumber; i++) {
            Task task = new Task();
            task.setName(mUserName);

            mTasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }
}