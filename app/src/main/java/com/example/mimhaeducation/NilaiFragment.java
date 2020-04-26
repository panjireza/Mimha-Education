package com.example.mimhaeducation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NilaiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Nilai");

        View view = inflater.inflate(R.layout.fragment_nilai, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_siswa);
        new FirebaseDatabaseHelper().readSiswa(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Nilai> siswas, List<String> keys) {
                new NilaiAdapter().setConfig(recyclerView, getContext(),
                        siswas,keys);
            }

            @Override
            public void DataIsInserted() { }

            @Override
            public void DataIsUpdated() { }

            @Override
            public void DataIsDeleted() { }
        });
        return view;
    }
}
