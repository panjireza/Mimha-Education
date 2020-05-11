package com.example.mimhaeducation.nilai;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimhaeducation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

public class NilaiFragment extends Fragment {

    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private TextView nilaiMath,nilaiBind,nilaiOlahragaa,nilaiAgama;
    private CardView cvMath,cvBind;

    private TextView mathUh1,mathUh2,mathUh3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Nilai");

        View view = inflater.inflate(R.layout.nilai_list_item, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("siswa").child("users");

        nilaiMath=view.findViewById(R.id.tvNilaiMath);
        nilaiBind=view.findViewById(R.id.tvNilaiBind);
        nilaiOlahragaa=view.findViewById(R.id.tvNilaiOlahraga);
        nilaiAgama=view.findViewById(R.id.tvNilaiAgama);
        cvMath=view.findViewById(R.id.cvMath);
        cvBind=view.findViewById(R.id.cvBind);


        Query query =databaseReference.orderByChild("Email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String math = ""+ds.child("math").getValue();
                    String bind = ""+ds.child("bind").getValue();
                    String olahraga = ""+ds.child("olahraga").getValue();
                    String agama = ""+ds.child("agama").getValue();

                    nilaiMath.setText(math);
                    nilaiBind.setText(bind);
                    nilaiOlahragaa.setText(olahraga);
                    nilaiAgama.setText(agama);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cvMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathDialog();
            }
        });

        cvBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindDialog();
            }
        });

        return view;
    }

    private void mathDialog() {

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("siswa").child("Matematika");


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("Email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mathUh1.setText(uh1);
                    mathUh2.setText(uh2);
                    mathUh3.setText(uh3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    private void bindDialog() {

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("siswa").child("Bindo");


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("Email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mathUh1.setText(uh1);
                    mathUh2.setText(uh2);
                    mathUh3.setText(uh3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

}
