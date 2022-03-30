package com.example.garbagemanagementsystem.ui.fragment.users;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.garbagemanagementsystem.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

     private ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.image_slider);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {

            ArrayList<SlideModel> slideModels = new ArrayList<>();

            if(slideModels != null){

                slideModels.add(new SlideModel(R.drawable.one, ScaleTypes.CENTER_CROP));
                slideModels.add(new SlideModel(R.drawable.two, ScaleTypes.CENTER_CROP));
                slideModels.add(new SlideModel(R.drawable.three,ScaleTypes.CENTER_CROP));
                slideModels.add(new SlideModel(R.drawable.four,ScaleTypes.CENTER_CROP));
                slideModels.add(new SlideModel(R.drawable.five,ScaleTypes.CENTER_CROP));

                imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

            }else{

                Log.d("Tag", " Failed to Add Image In Slider Module ");
            }

        }catch (Exception e){

            Log.d("Tag",e.toString());
        }

    }
}