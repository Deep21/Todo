package com.todo.data.datasource;

import dagger.Binds;
import dagger.Module;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link TaskDataStoreModule}.
 */
@Module
public abstract class TaskDataStoreModule {

    @Binds
    abstract TaskDataStoreInterface taskDataStore(RemoteTaskDataStore remoteTaskDataStore);

}
