package com.todo.presentation.di;

import android.content.Context;

import com.todo.domain.executor.ExecutionThread;
import com.todo.presentation.AndroidMainUiThread;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Samfisher on 04/09/2017.
 */
@Module
public abstract class AppModule {

    @Singleton
    @Binds
    abstract Context provideContext(App app);

    @Binds
    abstract ExecutionThread executionThread (AndroidMainUiThread androidMainUiThread);

}
