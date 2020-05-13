package com.example.mimhaeducation.jadwal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimhaeducation.R;

import java.util.List;

public class JadwalAdapter {

    private Context mContext;
    private JadwalsAdapter mJadwalAdapter;


    public void setConfig (RecyclerView recyclerView, Context context, List<Jadwal> jadwals, List<String> keys){
        mContext = context;
        mJadwalAdapter = new JadwalsAdapter(jadwals,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mJadwalAdapter);

    }

    class JadwalItemView extends RecyclerView.ViewHolder{
        private TextView mHari;
        private TextView mMapel;
        private TextView mTanggal;
        private TextView mKd;

        private String key;
        ConstraintLayout expandableLayoutNilai;


        public JadwalItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext)
                    .inflate(R.layout.jadwal_row, parent, false));

            mHari = (TextView) itemView.findViewById(R.id.hari);
            mMapel = (TextView) itemView.findViewById(R.id.matpel_satu);
            mTanggal = (TextView) itemView.findViewById(R.id.tanggal);
            mKd = (TextView) itemView.findViewById(R.id.kd);

            expandableLayoutNilai = itemView.findViewById(R.id.expandableLayout);

            mHari.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Jadwal jadwal = mJadwalAdapter.mJadwalList.get(getAdapterPosition());
                    jadwal.setExpanded(!jadwal.isExpanded());
                    mJadwalAdapter.notifyItemChanged(getAdapterPosition());
                }
            });

        }

        public void bind(Jadwal jadwal, String key){
            mHari.setText(jadwal.getHari());
            mMapel.setText(jadwal.getMatpelSatu());
            mTanggal.setText(jadwal.getTanggal());
            mKd.setText(jadwal.getKd());
            this.key = key;
        }
    }

    class JadwalsAdapter extends RecyclerView.Adapter<JadwalItemView>{
        private List<Jadwal> mJadwalList;
        private List<String> mKeys;

        public JadwalsAdapter(List<Jadwal> mJadwalList, List<String> mKeys) {
            this.mJadwalList = mJadwalList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public JadwalItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JadwalItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull JadwalItemView holder, int position) {
            holder.bind(mJadwalList.get(position), mKeys.get(position));

            boolean isExpanded = mJadwalAdapter.mJadwalList.get(position).isExpanded();
            holder.expandableLayoutNilai.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        }

        @Override
        public int getItemCount() {
            return mJadwalList.size();
        }
    }
}
