package com.todo.data.datasource;


import com.todo.data.entity.Task;
import com.todo.data.net.InvoiceApi;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Samfisher on 09/01/2018.
 */

public class RemoteTaskDataStore implements TaskRemoteDataStore<Task> {

  private InvoiceApi invoiceApi;

  @Inject
  public RemoteTaskDataStore(InvoiceApi invoiceApi) {
    this.invoiceApi = invoiceApi;
  }

  @Override
  public Observable<List<Task>> getList() {
    return invoiceApi.getList();
  }

  @Override
  public Observable<Task> get(int id) {
    return invoiceApi.get(id);
  }

  @Override
  public Observable<Task> post(Task task) {
    return invoiceApi.addTask(task);
  }

  @Override
  public Completable delete(int id) {
    return null;
  }

  @Override
  public Completable edit(Task contact) {
    return null;
  }

  @Override
  public Observable<List<Task>> search(String keyword) {
    return invoiceApi.search(keyword);
  }


}
