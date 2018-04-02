package com.todo.presentation.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.todo.presentation.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import com.todo.presentation.viewmodel.TaskViewModel;
import com.todo.presentation.viewmodel.TaskViewModelFactory;

public class TaskListActivity extends AppCompatActivity {

    @Inject TaskViewModelFactory taskViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskViewModel taskViewModel = obtainViewModel(this, taskViewModelFactory);
        taskViewModel.loadTasks();
    }

    public static TaskViewModel obtainViewModel(FragmentActivity activity, TaskViewModelFactory contactViewModelFactory) {
        return ViewModelProviders
                .of(activity, contactViewModelFactory)
                .get(TaskViewModel.class);
    }
}
