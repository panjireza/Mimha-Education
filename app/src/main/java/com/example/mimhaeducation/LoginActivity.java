package com.example.mimhaeducation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    EditText editTextNis, editTextPass;
    Button btLogin;
    TextView tvRegistrasi;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        editTextNis = findViewById(R.id.et_nis);
        editTextPass = findViewById(R.id.et_pass);
        btLogin = findViewById(R.id.login);
        tvRegistrasi = findViewById(R.id.tvRegistrasi);

        ref = FirebaseDatabase.getInstance().getReference("siswa").child("users");

        mAuthStateListner = new FirebaseAuth.AuthStateListener() {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mFirebaseUser != null ){
                    Toast.makeText(LoginActivity.this,"You Are Logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Please Log in", Toast.LENGTH_SHORT).show();
                }
            }
        };

        tvRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String nis = editTextNis.getText().toString();
                        String password = editTextPass.getText().toString();
                        if (nis.isEmpty()){
                            editTextNis.setError("Masukkan NIS");
                            editTextNis.requestFocus();
                        }else if (password.isEmpty()){
                            editTextPass.setError("Masukkan Password");
                            editTextPass.requestFocus();
                        }else if (nis.isEmpty() && password.isEmpty()){
                            Toast.makeText(LoginActivity.this,"Field Kosong", Toast.LENGTH_SHORT).show();
                        }else if (!(nis.isEmpty() && password.isEmpty())){
                            mFirebaseAuth.signInWithEmailAndPassword(nis,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this,"Loggin Error, please login again", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(LoginActivity.this,"Error Occured", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListner);
    }

    //    String pass;
//    public void btnLogin(View view) {
//        String nis = editTextNis.getText().toString();
//        pass = editTextPass.getText().toString();
//
//
//            ref.child(nis).addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    Siswa siswa = dataSnapshot.getValue(Siswa.class);
//                    if (dataSnapshot.exists()) {
//                        if (pass.equals(siswa.getPassword())) {
//                            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Masukkan Password yang Benar", Toast.LENGTH_SHORT).show();
//                        }
//                    }else {
//                        Toast.makeText(LoginActivity.this, "Siswa Tidak Ada", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//    }
}
