package com.example.taskmanager.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.taskmanager.R;
import com.example.taskmanager.controller.activity.TaskListActivity;
import com.google.android.material.textfield.TextInputLayout;

public class TaskDetailFragment extends Fragment {

    public static final String EXTRA_USER_NAME = "com.example.taskmanager.UserName";
    public static final String EXTRA_NUMBER_OF_TASKS = "com.example.taskmanager.numberOfTasks";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_NUMBER_OF_TASK = "numberOfTask";
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
        if(savedInstanceState != null){
            mEditTextUserName.getEditText().setText(savedInstanceState.getString(KEY_USER_NAME));
            mEditTextNumber.getEditText().setText(savedInstanceState.getString(KEY_NUMBER_OF_TASK));
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_USER_NAME, mEditTextUserName.getEditText().getText().toString());
        outState.putString(KEY_NUMBER_OF_TASK, mEditTextNumber.getEditText().getText().toString());
    }

    private void findViews(View view) {
        mEditTextUserName = view.findViewById(R.id.edittxt_username);
        mEditTextNumber = view.findViewById(R.id.edittxt_number);
        mButtonCreate = view.findViewById(R.id.btn_create);
    }

    private void initViews() {

    }

    private void setListeners() {
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mEditTextUserName.getEditText().getText().toString().trim().isEmpty()){
                    mEditTextUserName.setErrorEnabled(true);
                    mEditTextUserName.setError("Field can not be empty!!");

                }else if(mEditTextNumber.getEditText().getText().toString().length() == 0) {
                    mEditTextUserName.setErrorEnabled(false);
                    mEditTextNumber.setErrorEnabled(true);
                    mEditTextNumber.setError("Field can not be empty!!");
                }else{
                    mEditTextUserName.setErrorEnabled(false);
                    mEditTextNumber.setErrorEnabled(false);

                    Intent intent = new Intent(getActivity(), TaskListActivity.class);

                    intent.putExtra(EXTRA_USER_NAME,
                            mEditTextUserName.getEditText().getText().toString());
                    intent.putExtra(EXTRA_NUMBER_OF_TASKS,
                            Integer.parseInt(mEditTextNumber.getEditText().getText().toString()));

                    startActivity(intent);
                }
            }
        });
    }
}