package com.example.mimhaeducation.jadwal;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceJadwals;
    private List<Jadwal> jadwals = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Jadwal> jadwals, List<String> keys);
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceJadwals =mDatabase.getReference("siswa").child("Jadwal");
    }

    public void readJadwals(final DataStatus dataStatus){
        mReferenceJadwals.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                jadwals.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Jadwal jadwal = keyNode.getValue(Jadwal.class);
                    jadwals.add(jadwal);
                }
                dataStatus.DataIsLoaded(jadwals,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
