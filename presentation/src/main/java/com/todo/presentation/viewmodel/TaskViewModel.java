package com.todo.presentation.viewmodel;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.todo.domain.Contact;
import com.todo.domain.interactor.ContactRetrieveInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Samfisher on 22/11/2017.
 */

public class TaskViewModel extends ViewModel {

  private static final String TAG = "TaskViewModel";
  private ContactRetrieveInteractor taskInteractor;
  private MutableLiveData<Resource<Throwable>> error = new MutableLiveData<>();
  private MediatorLiveData<Resource> contactsListMediatorLiveData;

  @Inject
  public TaskViewModel(ContactRetrieveInteractor taskInteractor) {
    this.taskInteractor = taskInteractor;
  }

  public void loadTasks() {
      Disposable disposable = taskInteractor
              .getList()
              .subscribe(contacts -> Log.d(TAG, "accept: " + contacts.size()));
  }

}
