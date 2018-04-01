package com.todo.data.datasource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Samfisher on 09/01/2018.
 */

public interface TaskRemoteDataStore<T> {

  Observable<List<T>> getList();

  Observable<T> get(int id);

  Observable<T> post(T t);

  Completable delete(int id);

  Completable edit(T t);

  Observable<List<T>> search(String keyword);

}
