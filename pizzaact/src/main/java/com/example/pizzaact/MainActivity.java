package com.example.pizzaact;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.pizzaact.pizzadetailfrag;
import com.example.pizzaact.pizzamenufrag;

public class MainActivity extends AppCompatActivity  implements pizzamenufrag.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {

            pizzamenufrag firstFragment = new pizzamenufrag();


            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.flContainer, firstFragment);
            ft.commit();
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            pizzadetailfrag secondFragment = new pizzadetailfrag();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            secondFragment.setArguments(args);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.flContainer2, secondFragment);
            ft2.commit();
        }
    }

    @Override
    public void onPizzaItemSelected(int position) {
        Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();

        // Load Pizza Detail Fragment
        pizzadetailfrag secondFragment = new pizzadetailfrag();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment)

                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
