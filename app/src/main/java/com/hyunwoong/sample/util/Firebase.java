package com.hyunwoong.sample.util;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 12:16
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public final class Firebase {

    public static FirebaseAuth auth() {
        return FirebaseAuth.getInstance();
    }

    public static String uid() {
        return auth().getUid();
    }

    public static FirebaseAccessor reference() {
        return LazyHolder.instance.reference();
    }

    public static FirebaseAccessor reference(String root) {
        return LazyHolder.instance.reference(root);
    }

    static final class LazyHolder {
        static FirebaseAccessor instance = new FirebaseAccessor();
    }

    public final static class FirebaseAccessor {
        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        private FirebaseAccessor() {

        }

        private FirebaseAccessor reference() {
            reference = FirebaseDatabase.getInstance().getReference();
            return this;
        }

        private FirebaseAccessor reference(String root) {
            reference = FirebaseDatabase.getInstance().getReference(root);
            return this;
        }

        public FirebaseAccessor child(String path) {
            reference = reference.child(path);
            return this;
        }

        public <T> FirebaseProcessor<T> access(Class<T> clazz) {
            //RxJava Style
            return new FirebaseProcessor<>(reference);
        }
    }

    public final static class FirebaseProcessor<T> {
        private DatabaseReference reference;

        private FirebaseProcessor(DatabaseReference reference) {
            this.reference = reference;
        }

        public void insert(T val) {
            // insert and update are same
            reference.setValue(val);
        }

        public void delete() {
            reference.setValue(null);
        }

        public void select(Consumer<T> after) {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    T t = (T) dataSnapshot;
                    after.accept(t);
                }

                @Override public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
