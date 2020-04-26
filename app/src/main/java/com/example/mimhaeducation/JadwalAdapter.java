package com.example.mimhaeducation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalVH> {

    List<Jadwal> jadwalList;
    public JadwalAdapter(List<Jadwal> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @NonNull
    @Override
    public JadwalVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_row, parent, false);
        return new JadwalVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.JadwalVH holder, int position) {
        Jadwal jadwal = jadwalList.get(position);
        holder.hariTextView.setText(jadwal.getHari());
        holder.matpelSatuTextView.setText(jadwal.getMatpelSatu());
        holder.matpelDuaTextView.setText(jadwal.getMatpelDua());
        holder.matpelTigaTextView.setText(jadwal.getMatpelTiga());
        holder.matpelEmpatTextView.setText(jadwal.getMatpelEmpat());

        boolean isExpanded = jadwalList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class JadwalVH extends RecyclerView.ViewHolder {
        TextView hariTextView;
        TextView matpelSatuTextView;
        TextView matpelDuaTextView;
        TextView matpelTigaTextView;
        TextView matpelEmpatTextView;

        ConstraintLayout expandableLayout;

        public JadwalVH(@NonNull final View itemView) {
            super(itemView);

            hariTextView = itemView.findViewById(R.id.hari);
            matpelSatuTextView= itemView.findViewById(R.id.matpel_satu);
            matpelDuaTextView = itemView.findViewById(R.id.matpel_dua);
            matpelTigaTextView = itemView.findViewById(R.id.matpel_tiga);
            matpelEmpatTextView = itemView.findViewById(R.id.matpel_empat);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            hariTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Jadwal jadwal = jadwalList.get(getAdapterPosition());
                    jadwal.setExpanded(!jadwal.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
