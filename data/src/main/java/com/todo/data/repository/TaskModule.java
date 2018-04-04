package com.todo.data.repository;

import com.todo.data.datasource.RemoteTaskDataStore;
import com.todo.data.datasource.TaskDataStoreInterface;
import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import dagger.Binds;
import dagger.Module;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link TaskModule}.
 */
@Module
public abstract class TaskModule {

    @Binds
    abstract TaskRepositoryInterface taskRepository(TaskRepository taskRepository);

    @Binds
    abstract TaskDataStoreInterface taskDataStore(RemoteTaskDataStore remoteTaskDataStore);

}
