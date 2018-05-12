package com.todo.data.datasource;

import com.todo.data.entity.RealmTask;
import com.todo.data.entity.Task;
import com.todo.data.net.InvoiceApi;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Samfisher on 09/01/2018.
 */

public class TaskDataStoreFactory {

  private InvoiceApi invoiceApi;

  @Inject
  public TaskDataStoreFactory(InvoiceApi invoiceApi) {
    this.invoiceApi = invoiceApi;
  }

  public TaskLocalDataStore<RealmTask> createLocalStore() {
    return new LocalTaskDataStore(Realm.getDefaultInstance());
  }

  public TaskDataStoreInterface create() {
    return new RemoteTaskDataStore(invoiceApi);
  }
}
