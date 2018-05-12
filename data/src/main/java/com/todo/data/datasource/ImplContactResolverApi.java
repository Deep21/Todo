package com.todo.data.datasource;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.todo.data.entity.ContactEntity;
import com.todo.data.entity.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ImplContactResolverApi implements IContactDataStore {

    private Context context;

    @Inject
    public ImplContactResolverApi(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<ContactEntity>> getList() {
        return Observable
                .create(new ObservableOnSubscribe<List<ContactEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ContactEntity>> emitter) throws Exception {
                String order = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC";
                Cursor cursor = context
                        .getContentResolver()
                        .query(ContactsContract.Contacts.CONTENT_URI, null,null, null, order);

                if (cursor != null) {
                    List<ContactEntity> contactEntities = new ArrayList<>();

                    while (cursor.moveToNext()){
                        ContactEntity contactEntity = new ContactEntity();
                        String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String photoThumb = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
                        contactEntity.setId(id);
                        contactEntity.setName(displayName);
                        contactEntities.add(contactEntity);
                        emitter.onNext(contactEntities);
                    }

                    emitter.onComplete();
                    cursor.close();
                }

            }
        });

    }

    @Override
    public Observable<Task> get(int id) {
        return null;
    }

    @Override
    public Observable<Task> post(Task t) {
        return null;
    }

    @Override
    public Completable delete(int id) {
        return null;
    }

    @Override
    public Completable edit(Task t) {
        return null;
    }

    @Override
    public Observable<List<Task>> search(String keyword) {
        return null;
    }
}
