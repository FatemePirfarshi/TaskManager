package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public static TaskRepository sInstance;

    private List<Task> mTasks;
    private static String sUserName;
    private static int sNumber;

    public static TaskRepository getInstance(int initialNum, String userName){
        if(sInstance == null)
            sInstance = new TaskRepository(initialNum, userName);

        return sInstance;
    }

    private TaskRepository(int initialNum, String userName){
        sUserName = userName;
        mTasks = new ArrayList<>();

        for (int i = 0; i < initialNum; i++) {
            Task task = new Task();
            task.setName(sUserName);

            mTasks.add(task);
        }
    }

    public int getNumber() {
        return sNumber;
    }

    public void setNumber(int number) {
        sNumber = number;
    }

    public void addTask(){
        Task task = new Task();
        task.setName(sUserName);

        mTasks.add(task);
    }

    public List<Task> getTasks() {
        return mTasks;
    }
}