package com.example.mimhaeducation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;

import io.opencensus.tags.TagContext;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    EditText etNama, etEmail, etPassword, etNis;
    Button btRegister;
    TextView tvLogin;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etNis = findViewById(R.id.etNis);
        etPassword = findViewById(R.id.etPasword);
        btRegister = findViewById(R.id.btRegister);
        tvLogin = findViewById(R.id.tvLogin);

        databaseReference = FirebaseDatabase.getInstance().getReference("siswa").child("job1");
        firebaseAuth = FirebaseAuth.getInstance();

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = etNama.getText().toString();
                final String email = etEmail.getText().toString();
                final String nis = etNis.getText().toString();
                final String password = etPassword.getText().toString();

                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(nama) &&
                    TextUtils.isEmpty(nis) && TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Lengkapi Data",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Siswa siswa = new Siswa(
                                            nis,
                                            nama,
                                            email,
                                            password
                                    );

                                    FirebaseDatabase.getInstance().getReference("siswa").child("job1")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(siswa).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(RegisterActivity.this,"Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        }
                                    });

                                } else {
                                }

                            }
                        });

            }
        });


    }
}
