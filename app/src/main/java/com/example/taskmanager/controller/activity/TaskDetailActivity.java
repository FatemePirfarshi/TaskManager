package com.example.taskmanager.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.taskmanager.controller.fragment.TaskDetailFragment;

public class TaskDetailActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new TaskDetailFragment();
    }
}