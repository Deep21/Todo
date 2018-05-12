package com.todo.presentation.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.todo.presentation.BuildConfig;
import com.todo.presentation.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import com.todo.presentation.viewmodel.TaskViewModel;
import com.todo.presentation.viewmodel.TaskViewModelFactory;

public class TaskListActivity extends AppCompatActivity {

    @Inject TaskViewModelFactory taskViewModelFactory;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        }

        TaskViewModel taskViewModel = obtainViewModel(this, taskViewModelFactory);
        taskViewModel.loadTasks();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                Toast.makeText(this, "SHOW", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static TaskViewModel obtainViewModel(FragmentActivity activity, TaskViewModelFactory contactViewModelFactory) {
        return ViewModelProviders
                .of(activity, contactViewModelFactory)
                .get(TaskViewModel.class);
    }
}
