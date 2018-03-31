package com.todo.presentation.di;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.todo.presentation.TaskListActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Samfisher on 04/09/2017.
 */

@Module
abstract class ActivityBindingsModule {

  @PerActivity
  @ContributesAndroidInjector
  abstract TaskListActivity bindActivity();


  @Provides
  @PerActivity
  static FragmentManager activityFragmentManager(FragmentActivity activity) {
    return activity.getSupportFragmentManager();
  }
}
