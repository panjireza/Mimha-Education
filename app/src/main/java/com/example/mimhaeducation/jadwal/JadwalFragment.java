package com.example.mimhaeducation.jadwal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimhaeducation.R;
import com.example.mimhaeducation.jadwal.Jadwal;
import com.example.mimhaeducation.jadwal.JadwalAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JadwalFragment extends Fragment {

    RecyclerView recyclerView;

    List<Jadwal> jadwalList;

    TextView dateTextView, timeTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Jadwal");
        final View view = inflater.inflate(R.layout.fragment_jadwal, container, false);

        final boolean keepRunning1 = true;
        Thread t = new Thread(){
            @Override
            public void run(){
                while (keepRunning1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "Default Signature Fail", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    if(getActivity() == null)
                        return;
                    getActivity().runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            dateTextView = view.findViewById(R.id.currentDate);
                            timeTextView = view.findViewById(R.id.currentTime);
                            long date = System.currentTimeMillis();
                            SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMMM yyyy");
                            SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm a");
                            String dateString = sdfDate.format(date);
                            String timeString = sdfTime.format(date);
                            dateTextView.setText(dateString);
                            timeTextView.setText(timeString);
                        }
                    });
                }
            }
        };

        t.start();

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_expandables_jadwal);


        initData();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        JadwalAdapter jadwalAdapter = new JadwalAdapter(jadwalList);
        recyclerView.setAdapter(jadwalAdapter);
    }

    private void initData() {
        jadwalList = new ArrayList<>();
        jadwalList.add(new Jadwal("Senin", "Matematika", "Bahasa Indonesia", "Bahasa Inggris", "Agama Islam"));
        jadwalList.add(new Jadwal("Selasa", "Matematika", "Bahasa Indonesia", "Bahasa Inggris", "Agama Islam"));
        jadwalList.add(new Jadwal("Rabu", "Matematika", "Bahasa Indonesia", "Bahasa Inggris", "Agama Islam"));
    }
}
