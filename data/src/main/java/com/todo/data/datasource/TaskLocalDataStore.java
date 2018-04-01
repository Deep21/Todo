package com.todo.data.datasource;

import com.todo.data.entity.RealmTask;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Samfisher on 09/01/2018.
 */

public interface TaskLocalDataStore<T> {

  Observable<List<T>> getList();

  Observable<T> getContact(int id);

  Completable postTask(RealmTask realmTask);

}
