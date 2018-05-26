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
                                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                                getImageById(contactId);

                            }

                            cursor.close();

                        }

                        emitter.onComplete();

                    }


                });

    }

    public void getNoteById(String id) {
        String noteWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] noteWhereParams = new String[]{id, ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE};
        Cursor noteCur = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, noteWhere, noteWhereParams, null);

        if (noteCur != null && noteCur.moveToFirst()) {
            String note = noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE));
            noteCur.close();
        }

    }

    public void getPhoneNumber(String id){
        Cursor cursorPhone = context
                .getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);

        if (cursorPhone != null) {
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

    }

    public void getAddressById(String id){
        Cursor postalCursor = context
                .getContentResolver()
                .query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, ContactsContract.Data.CONTACT_ID + " = " + id, null, null);

        if (postalCursor != null) {

            while (postalCursor.moveToNext()) {
                int postalType = postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE);

                String street = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
                String city = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
                String country = postalCursor.getString(postalCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));

                switch (postalType) {
                    case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_HOME:
                        Log.d(TAG, "HOME address" + street);
                        break;
                    case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_OTHER:
                        Log.d(TAG, "OTHER address" + street);
                        break;
                    case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK:
                        Log.d(TAG, "WORK address"  + street);
                        break;
                }
            }
            postalCursor.close();

        }
    }


    public void getImageById(String id){
        String imWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] imWhereParams = new String[]{id, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE};
        Cursor imCur = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                null, imWhere, imWhereParams, null);

        if (imCur != null && imCur.moveToFirst()) {
            String imName = imCur.getString(imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.DATA));
            String imType  = imCur.getString(imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.TYPE));
            Log.d(TAG, "getImageById: " + imName);
            Log.d(TAG, "getImageById: " + imType);
            imCur.close();
        }
    }


    public void getEmailbyId(int id){
        Cursor emails = context
                .getContentResolver()
                .query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + id, null, null);

        if (emails != null) {

            while (emails.moveToNext()) {
                int emailType = emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE);
                String email = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                Log.d(TAG, "subscribe: home" + email);
            }

            emails.close();
        }
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