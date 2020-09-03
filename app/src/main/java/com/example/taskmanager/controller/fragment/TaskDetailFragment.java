package com.example.taskmanager.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.taskmanager.R;
import com.example.taskmanager.controller.activity.TaskListActivity;
import com.google.android.material.textfield.TextInputLayout;

public class TaskDetailFragment extends Fragment {

    public static final String EXTRA_USER_NAME = "UserName";
    public static final String EXTRA_NUMBER_OF_TASKS = "numberOfTasks";
    private TextInputLayout mEditTextUserName;
    private TextInputLayout mEditTextNumber;
    private Button mButtonCreate;

    public TaskDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        findViews(view);
        initViews();
        setListeners();
        return view;
    }

    private void findViews(View view) {
        mEditTextUserName = view.findViewById(R.id.edittxt_username);
        mEditTextNumber = view.findViewById(R.id.edittxt_number);
    }

    private void initViews() {

    }

    private void setListeners() {
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , TaskListActivity.class);

                intent.putExtra(EXTRA_USER_NAME,
                        mEditTextUserName.getEditText().getText().toString());
                intent.putExtra(EXTRA_NUMBER_OF_TASKS,
                        Integer.parseInt(mEditTextNumber.getEditText().getText().toString()));

                startActivity(intent);
            }
        });
    }
}