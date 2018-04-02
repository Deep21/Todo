package com.todo.presentation.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.todo.presentation.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class DetailTaskActivity extends AppCompatActivity implements HasSupportFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
  private static final String TAG = "DetailTaskActivity";
  public static final String EXTRA_TASK_ID = "EXTRA_TASK_ID";

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    Log.d(TAG, "onSaveInstanceState: set 5");
    outState.putInt("key", 5);
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    Log.d(TAG, "onRestoreInstanceState: " + savedInstanceState.getInt("key"));
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_task);
    setUpToolBar();
    setUpFab();
    loadDetailFragment();
  }

  public void loadDetailFragment() {
  }

  private void setUpToolBar() {
  }

  private void setUpFab() {
  }

  @Override
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}
