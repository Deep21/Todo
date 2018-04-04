package com.todo.data.datasource;

import com.todo.data.entity.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Samfisher on 09/01/2018.
 */

public interface TaskDataStoreInterface {

  Observable<List<Task>> getList();

  Observable<Task> get(int id);

  Observable<Task> post(Task t);

  Completable delete(int id);

  Completable edit(Task t);

  Observable<List<Task>> search(String keyword);

}
