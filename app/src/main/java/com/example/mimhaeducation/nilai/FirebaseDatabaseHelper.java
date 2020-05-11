package com.example.mimhaeducation.nilai;

import androidx.annotation.NonNull;

import com.example.mimhaeducation.nilai.Nilai;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceSiswa;
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private List<Nilai> nilais = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Nilai> siswas, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper() {
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance();

    }

    public void readSiswa(final DataStatus dataStatus){
        mReferenceSiswa = mDatabase.getReference("siswa").child("Matematika");
        Query query =mReferenceSiswa.orderByChild("Email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nilais.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Nilai nilai = keyNode.getValue(Nilai.class);
                    nilais.add(nilai);
                }
                dataStatus.DataIsLoaded(nilais,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
