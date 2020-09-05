package com.example.taskmanager.model;

import android.graphics.drawable.Drawable;

import com.example.taskmanager.R;

import java.util.Random;
import java.util.UUID;

public class Task {

    private UUID mId;
    private String mName;
    private State mState;
    private int imageRes;

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public State getState() {
        return mState;
    }

    public Task() {
        mId = UUID.randomUUID();
        mState = State.values()[new Random().nextInt(State.values().length)];
        setStateImage(mState);
    }

    public void setStateImage(State state) {
       switch (state){
           case DONE:
               imageRes = R.drawable.ic_done;
               break;
           case DOING:
               imageRes = R.drawable.ic_doing;
               break;
           default:
               imageRes = R.drawable.ic_todo;
               break;
       }
    }
}
