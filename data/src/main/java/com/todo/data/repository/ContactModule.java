package com.todo.data.repository;

import com.todo.data.datasource.IContactDataStore;
import com.todo.data.datasource.ImplContactResolverApi;
import com.todo.domain.repository.ContactRepositoryInterface;

import dagger.Binds;
import dagger.Module;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link ContactModule}.
 */
@Module
public abstract class ContactModule {

    @Binds
    abstract ContactRepositoryInterface taskRepository(ImplContactRepository implContactRepository);

    @Binds
    abstract IContactDataStore taskDataStore(ImplContactResolverApi implContactResolverApi);


}
