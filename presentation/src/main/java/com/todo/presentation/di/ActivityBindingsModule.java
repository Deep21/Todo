package com.todo.presentation.di;

import com.todo.data.datasource.TaskDataStoreModule;
import com.todo.data.repository.TaskRepositoryModule;
import com.todo.presentation.view.TaskListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Samfisher on 04/09/2017.
 */

@Module
abstract class ActivityBindingsModule {

  @PerActivity
  @ContributesAndroidInjector(modules = {
          TaskRepositoryModule.class,
          TaskDataStoreModule.class
  })

  abstract TaskListActivity bindActivity();


}
