package com.example.mimhaeducation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NilaiAdapter {
    private Context mContext;
    private SiswaAdapter mSiswaAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Nilai> siswas, List<String> keys){
        mContext = context;
        mSiswaAdapter = new SiswaAdapter(siswas,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSiswaAdapter);
    }

    class SiswaItemView extends RecyclerView.ViewHolder{
        private TextView mNama;
        private TextView mOrtu;
        private TextView mGuru;
        private TextView mKelas;
        private ImageView mArrowDown, mArrowUp;

        private String key;
        ConstraintLayout expandableLayoutNilai;

        public SiswaItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.nilai_list_item, parent, false));

            mNama = (TextView) itemView.findViewById(R.id.tv_nama);
            mOrtu = (TextView) itemView.findViewById(R.id.tv_ortu);
            mGuru = (TextView) itemView.findViewById(R.id.tv_guru);
            mKelas = (TextView) itemView.findViewById(R.id.tv_kelas);
            mArrowDown = (ImageView) itemView.findViewById(R.id.arrowDown);
            mArrowUp = (ImageView) itemView.findViewById(R.id.arrowUp);

            expandableLayoutNilai = itemView.findViewById(R.id.expandableLayoutNilai);

            mNama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Nilai nilai = mSiswaAdapter.mSiswaList.get(getAdapterPosition());
                    nilai.setExpanded(!nilai.isExpanded());
                    mSiswaAdapter.notifyItemChanged(getAdapterPosition());
                }
            });
        }

        public void bind(Nilai siswa, String key){
            mNama.setText(siswa.getMapel());
            mOrtu.setText(String.valueOf(siswa.getUlangan2()));
            mGuru.setText(String.valueOf(siswa.getUlangan1()));
            mKelas.setText(String.valueOf(siswa.getUlangan3()));
            this.key = key;
        }
    }
    class SiswaAdapter extends  RecyclerView.Adapter<SiswaItemView>{
        private List<Nilai> mSiswaList;
        private List<String> mKeys;

        public SiswaAdapter(List<Nilai> mSiswaList, List<String> mKeys){
            this.mSiswaList = mSiswaList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public SiswaItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SiswaItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SiswaItemView holder, int position) {
            holder.bind(mSiswaList.get(position), mKeys.get(position));

            boolean isExpanded = mSiswaAdapter.mSiswaList.get(position).isExpanded();
            holder.expandableLayoutNilai.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            if (isExpanded == true){
                holder.mArrowDown.setVisibility(View.GONE);
            }else {
                holder.mArrowUp.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return mSiswaList.size();
        }
    }


}
