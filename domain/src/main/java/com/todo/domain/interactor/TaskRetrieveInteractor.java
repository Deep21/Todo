package com.todo.domain.interactor;

import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TaskRetrieveInteractor implements TaskInteractorInterface<Task>{

    private TaskRepositoryInterface repository;


    /**
     * We are injecting the implement class of TaskRepositoryInterface
     * @param repository
     */
    @Inject
    public TaskRetrieveInteractor(TaskRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Task>> getList() {
        return repository.getTasks();
    }

    @Override
    public Observable<Task> get(int i) {
        return null;
    }
}
