package com.example.finalproject.HomeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.CalculateGPA.Five_Subjects;
import com.example.finalproject.CalculateGPA.Six_Subjects;
import com.example.finalproject.R;


public class Calc_GpaFragment extends Fragment {
    Button six , five ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_college_map, container, false);

        six = view.findViewById(R.id.calculate_6);
        five = view.findViewById(R.id.calculate_5);

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment six_fragment = new Six_Subjects();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, six_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment five_fragment = new Five_Subjects();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, five_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }
}