package com.todo.domain.interactor;

import com.todo.domain.Contact;
import com.todo.domain.executor.ExecutionThread;
import com.todo.domain.repository.ContactRepositoryInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


public class ContactRetrieveInteractor implements ContactInteractorInterface<Contact> {

    private static final Object TAG = "ContactRetrieveInteractor";
    private ContactRepositoryInterface repository;
    private ExecutionThread executionThread;

    /**
     * We are injecting the implemented class of ContactRepositoryInterface
     * @param repository
     */
    @Inject
    public ContactRetrieveInteractor(ContactRepositoryInterface repository, ExecutionThread executionThread) {
        this.repository = repository;
        this.executionThread = executionThread;
    }

    @Override
    public Observable<List<Contact>> getList() {
        return repository
                .getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(executionThread.getScheduler());
    }

    @Override
    public Observable<Contact> get(int i) {
        return null;
    }
}
