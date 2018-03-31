package com.todo.domain.interactor;


import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 11/01/2018.
 */

public class AddTaskInteractor implements TaskInteractorInterface.PostInteractorInterface<Task> {

    private TaskRepositoryInterface taskRepositoryInterface;

    @Inject
    public AddTaskInteractor(TaskRepositoryInterface repository) {
        this.taskRepositoryInterface = repository;
    }

    @Override
    public Observable<Task> post(Task task) {
        return null;
    }
}
