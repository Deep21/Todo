package com.todo.data.repository;

import android.util.Log;

import com.todo.data.datasource.IContactDataStore;
import com.todo.data.entity.ContactEntity;
import com.todo.domain.Contact;
import com.todo.domain.repository.ContactRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by afp on 27/03/18.
 */

public class ImplContactRepository implements ContactRepositoryInterface {

    private static final String TAG = "ImplContactRepository";
    private IContactDataStore iContactDataStore;

    /**
     * We're injecting the implemented class of TaskDataStoreInterface
     */
    @Inject
    public ImplContactRepository(IContactDataStore iContactDataStore) {
      this.iContactDataStore = iContactDataStore;
    }

    @Override
    public Observable<List<Contact>> getTasks() {
        return iContactDataStore
                .getList().map(new Function<List<ContactEntity>, List<Contact>>() {
            @Override
            public List<Contact> apply(List<ContactEntity> contactEntities) throws Exception {
                List<Contact> contactList = new ArrayList<>();
                for (ContactEntity contactEntity : contactEntities){
                    Contact contact = new Contact();
                    contact.setId(contactEntity.getId());
                    contactList.add(contact);
                }
                return contactList;
            }
        });
    }

    @Override
    public Observable<Contact> getTask(int taskId) {
        return null;
    }

    @Override
    public Observable<List<Contact>> search(String keyword) {
        return null;
    }

    @Override
    public Observable<Contact> post(Contact task) {
        return null;
    }
}


