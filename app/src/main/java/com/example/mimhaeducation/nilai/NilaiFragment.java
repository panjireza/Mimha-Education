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

import java.text.DecimalFormat;
import java.util.List;

public class NilaiFragment extends Fragment {

    public void authMethod(){
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private TextView nilaiMath,nilaiBind,nilaiOlahragaa,nilaiAgama;
    private CardView cvMath,cvBind,cvOl,cvAgama;

    private TextView mathUh1,mathUh2,mathUh3, mapel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Nilai");

        View view = inflater.inflate(R.layout.nilai_list_item, container, false);

        authMethod();
        databaseReference = firebaseDatabase.getReference("siswa").child("job1");

        nilaiMath=view.findViewById(R.id.tvNilaiMath);
        nilaiBind=view.findViewById(R.id.tvNilaiBind);
        nilaiOlahragaa=view.findViewById(R.id.tvNilaiOlahraga);
        nilaiAgama=view.findViewById(R.id.tvNilaiAgama);
        cvMath=view.findViewById(R.id.cvMath);
        cvBind=view.findViewById(R.id.cvBind);
        cvOl=view.findViewById(R.id.cvOl);
        cvAgama=view.findViewById(R.id.cvAgama);


        Query query =databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String math = ""+ds.child("matematika").getValue();
                    String bind = ""+ds.child("bahasa").getValue();
                    String olahraga = ""+ds.child("olahraga").getValue();
                    String agama = ""+ds.child("agama").getValue();

                    Double mathConvert = Double.parseDouble(math);
                    Double bindConvert = Double.parseDouble(bind);
                    Double orConvert = Double.parseDouble(olahraga);
                    Double agamaConvert = Double.parseDouble(agama);

                    nilaiMath.setText(String.format("%.2f", mathConvert));
                    nilaiBind.setText(String.format("%.2f", bindConvert));
                    nilaiOlahragaa.setText(String.format("%.2f", orConvert));
                    nilaiAgama.setText(String.format("%.2f", agamaConvert));
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

        cvOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                olahragaDialog();
            }
        });

        cvAgama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agamaDialog();
            }
        });

        return view;
    }

    private void mathDialog() {

        authMethod();
        databaseReference = firebaseDatabase.getReference("siswa").child("matematika");

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mapel=mView.findViewById(R.id.tvmapel);
        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mapel.setText("Nilai Matematika");
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

        authMethod();
        databaseReference = firebaseDatabase.getReference("siswa").child("bahasa");

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mapel=mView.findViewById(R.id.tvmapel);
        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mapel.setText("Nilai Bahasa Indonesia");
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

    private void olahragaDialog() {

        authMethod();
        databaseReference = firebaseDatabase.getReference("siswa").child("olahraga");

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mapel=mView.findViewById(R.id.tvmapel);
        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mapel.setText("Nilai Olahraga");
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

    private void agamaDialog() {

        authMethod();
        databaseReference = firebaseDatabase.getReference("siswa").child("agama");

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.math_dialog, null);

        mapel=mView.findViewById(R.id.tvmapel);
        mathUh1=mView.findViewById(R.id.uh1);
        mathUh2=mView.findViewById(R.id.uh2);
        mathUh3=mView.findViewById(R.id.uh3);

        Query query =databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String uh1 = ""+ds.child("uh1").getValue();
                    String uh2 = ""+ds.child("uh2").getValue();
                    String uh3 = ""+ds.child("uh3").getValue();

                    mapel.setText("Nilai Pendidikan Agama");
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
