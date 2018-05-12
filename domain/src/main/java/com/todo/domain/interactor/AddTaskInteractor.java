package com.todo.domain.interactor;


import com.todo.domain.Contact;
import com.todo.domain.repository.ContactRepositoryInterface;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 11/01/2018.
 */

public class AddTaskInteractor implements ContactInteractorInterface.PostInteractorInterface<Contact> {

    private ContactRepositoryInterface contactRepositoryInterface;

    @Inject
    public AddTaskInteractor(ContactRepositoryInterface repository) {
        this.contactRepositoryInterface = repository;
    }

    @Override
    public Observable<Contact> post(Contact task) {
        return null;
    }
}
