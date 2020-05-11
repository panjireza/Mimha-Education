package com.example.mimhaeducation.beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimhaeducation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BerandaFragment extends Fragment {

    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    TextView showUser;

    public Fragment newInstance() {
        return new BerandaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Beranda");
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyler_card_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());

//
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser =
//
//        showUser.setText(firebaseUser.);

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CardView mcardView;
        private TextView mTextView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view, container, false));

            mcardView = itemView.findViewById(R.id.card_container);
            mTextView = itemView.findViewById(R.id.text_holder);
        }

    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}
