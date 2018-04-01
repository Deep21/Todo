package com.todo.domain.interactor;

import com.todo.domain.Task;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TaskRetrieveInteractor implements TaskInteractorInterface<Task>{

    @Inject
    public TaskRetrieveInteractor() {
    }

    @Override
    public Observable<List<Task>> getList() {
        return null;
    }

    @Override
    public Observable<Task> get(int i) {
        return null;
    }
}
