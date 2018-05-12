package com.todo.presentation;

import com.todo.domain.executor.ExecutionThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class AndroidMainUiThread implements ExecutionThread {

    @Inject
    public AndroidMainUiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
