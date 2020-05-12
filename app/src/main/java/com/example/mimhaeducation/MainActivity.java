package com.example.mimhaeducation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mimhaeducation.beranda.BerandaFragment;
import com.example.mimhaeducation.biodata.BiodataFragment;
import com.example.mimhaeducation.jadwal.JadwalFragment;
import com.example.mimhaeducation.nilai.NilaiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public Fragment createFragment() {
        return new JadwalFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFrag = null;

                    switch (menuItem.getItemId()) {
//                        case R.id.nav_beranda:
//                            selectedFrag = new BerandaFragment();
//                            break;
                        case R.id.nav_jadwal:
                            selectedFrag = new JadwalFragment();
                            break;
                        case R.id.nav_nilai:
                            selectedFrag = new NilaiFragment();
                            break;
                        case R.id.nav_bio:
                            selectedFrag = new BiodataFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
                    return true;
                }
            };

}
