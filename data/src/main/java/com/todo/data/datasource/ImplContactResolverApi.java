package com.todo.data.datasource;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import com.todo.data.entity.ContactEntity;
import com.todo.data.entity.Task;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ImplContactResolverApi implements IContactDataStore {

    private static final String TAG = "ImplContactResolverApi";
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
                        Cursor cursor = context
                                .getContentResolver()
                                .query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                        if (cursor != null) {
                            while (cursor.moveToNext()) {

                                String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                                Cursor cursorPhone = context
                                        .getContentResolver()
                                        .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);

                                if (cursorPhone != null) {
                                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                                    Log.d(TAG, "subscribe: " + name);
                                    while (cursorPhone.moveToNext()) {
                                        String phNumber = cursorPhone
                                                .getString(cursorPhone
                                                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                                        int phoneType = cursorPhone
                                                .getInt(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));

                                        switch (phoneType) {
                                            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                                Log.d(TAG, "subscribe: HOME " + phNumber);
                                                break;
                                            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                                Log.d(TAG, "subscribe: MOBILE " + phNumber);
                                                break;
                                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                                Log.d(TAG, "subscribe: WORK " + phNumber);
                                                break;
                                        }
                                    }

                                    cursorPhone.close();
                                }

                                Cursor postalCursor = context
                                        .getContentResolver()
                                        .query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, ContactsContract.Data.CONTACT_ID + " = " + contactId, null, null);

                                if (postalCursor != null) {
                                    int postalType = postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE);

                                    while (postalCursor.moveToNext()) {
                                        String street = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
                                        String city = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
                                        String country = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));
                                        Log.d(TAG, "subscribe:" + street + postalType);

                                        switch (postalType) {
                                            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_HOME:
                                                Log.d(TAG, "subscribe: home" + street);
                                                break;
                                            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_OTHER:
                                                Log.d(TAG, "subscribe: other" + street);
                                                break;
                                            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK:
                                                Log.d(TAG, "subscribe: work" + street);
                                                break;
                                        }

                                    }
                                }

                                Cursor emails = context
                                        .getContentResolver()
                                        .query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId, null, null);

                                if (emails != null) {
                                    while (emails.moveToNext()) {
                                        String email = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                                        Log.d(TAG, "email: " + email);
                                    }
                                }

                            }
                        }

                        emitter.onComplete();

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