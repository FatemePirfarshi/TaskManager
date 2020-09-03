package com.example.taskmanager.model;

import java.util.Random;
import java.util.UUID;

public class Task {

    private UUID mId;
    private String mName;
    private State mState;

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
    }
}
