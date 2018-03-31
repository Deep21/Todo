package com.todo.presentation.di;


import com.todo.data.net.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Samfisher on 04/09/2017.
 */
@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    NetModule.class,
    ActivityBindingsModule.class})
public interface AppComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(App application);

    AppComponent build();
  }

  void inject(App app);

}