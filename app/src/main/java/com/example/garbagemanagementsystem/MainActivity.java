package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.garbagemanagementsystem.databinding.ActivityMainBinding;
import com.example.garbagemanagementsystem.ui.fragment.users.HomeFragment;
import com.example.garbagemanagementsystem.ui.fragment.users.MapFragment;
import com.example.garbagemanagementsystem.ui.fragment.users.ProfileFragment;
import com.example.garbagemanagementsystem.ui.fragment.work.AnimalDeathFragment;
import com.example.garbagemanagementsystem.ui.fragment.work.CleanSewageFragment;
import com.example.garbagemanagementsystem.ui.fragment.work.HomeWasteFragment;
import com.example.garbagemanagementsystem.ui.fragment.work.PublicWasteFragment;
import com.example.garbagemanagementsystem.ui.fragment.work.RaiseSewageFragment;



public class MainActivity extends AppCompatActivity {

     ActivityMainBinding binding;

     public void homeWasteTab(View view){

         replaceFragment(new HomeWasteFragment());
     }

     public void publicWasteTap(View view){

         Log.d("publicWasteTap", "Called");

        replaceFragment(new PublicWasteFragment());

    }

     public void cleanSewageTap(View view){

        replaceFragment(new CleanSewageFragment());

     }

     public void raiseSewageTap(View view){

        replaceFragment(new RaiseSewageFragment());

    }

     public void animalDeathTap(View view){

        replaceFragment(new AnimalDeathFragment());

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.mainBottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.Home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.Map:
                    replaceFragment(new MapFragment());
                    break;

                case R.id.Profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }


            return true ;
        });

    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
    }

}
