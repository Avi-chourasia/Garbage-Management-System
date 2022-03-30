package com.example.garbagemanagementsystem.ui.fragment.work;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.garbagemanagementsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class HomeWasteFragment extends Fragment {

    FirebaseFirestore fireStore;

    TextInputEditText t1,t2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_waste, container, false);

         t1 = view.findViewById(R.id.text_area_name);
         t2 = view.findViewById(R.id.text_quality_name);

        fireStore = FirebaseFirestore.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertdata();
            }

            private void insertdata() {

                Map<String,String> item = new HashMap<>();
                item.put("name",t1.getText().toString().trim());
                item.put("Discription",t2.getText().toString().trim());


                fireStore.collection("HomeWaste").add(item)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                t1.setText("");
                                t2.setText("");

                                Toast.makeText(getContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}