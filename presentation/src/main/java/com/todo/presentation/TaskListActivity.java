package com.todo.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.todo.domain.interactor.AddTaskInteractor;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class TaskListActivity extends AppCompatActivity{
    @Inject
    AddTaskInteractor addTaskInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("AddTaskInteractor",  addTaskInteractor.toString());
    }

}
