package com.todo.data.datasource;


import com.todo.data.entity.RealmTask;
import com.todo.data.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Samfisher on 09/01/2018.
 */

public class LocalTaskDataStore implements TaskLocalDataStore<RealmTask> {

  @Inject
  public LocalTaskDataStore() {
  }

  @Override
  public Observable<List<RealmTask>> getList() {
    return null;
  }

  public Observable<List<Task>> f() {
    Realm realm = Realm.getDefaultInstance();
    RealmResults<RealmTask> contactRealmResults = realm.where(RealmTask.class).findAll();
    return Observable.fromIterable(realm.copyFromRealm(contactRealmResults))
        .map(new Function<RealmTask, List<Task>>() {
          @Override
          public List<Task> apply(RealmTask realmTask) throws Exception {
            List<Task> tasks = new ArrayList<>();
            return tasks;
          }
        });
  }


  @Override
  public Observable<RealmTask> getContact(int id) {
    return null;
  }

  @Override
  public Completable postTask(RealmTask realmTask) {
    Realm realm = Realm.getDefaultInstance();
    realm.beginTransaction();
    RealmTask realmTask1 = realm.createObject(RealmTask.class, UUID.randomUUID().toString());
    realmTask1.setDescription("ef");
    realmTask1.setTitle("r");
    realm.commitTransaction();
    return Completable.complete();
  }

}