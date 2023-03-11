package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (Button) findViewById(R.id.button1);
        secondFragment = (Button) findViewById(R.id.button2);

        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new FragmentA());
            }
        });

        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentB());
            }
        });
    }

    private void loadFragment(FragmentA fragmentA) {
        FragmentManager fa = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fa.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragmentA);
        fragmentTransaction.commit();
    }

    private void loadFragment(FragmentB fragmentB) {
        FragmentManager fa = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fa.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragmentB);
        fragmentTransaction.commit();
    }
}