package com.todo.data.repository;

import com.todo.domain.repository.TaskRepositoryInterface;

import dagger.Binds;
import dagger.Module;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link TaskRepositoryModule}.
 */
@Module
public abstract class TaskRepositoryModule {

    @Binds
    abstract TaskRepositoryInterface taskRepository(TaskRepository taskRepository);
}
