package com.example.taskmanager.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.taskmanager.controller.fragment.TaskListFragment;

public class TaskListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new TaskListFragment();
    }
}