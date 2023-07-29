package com.example.finalproject.HomeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.AboutCollege.CollegeDepartments_Fragment;
import com.example.finalproject.AboutCollege.CollegeObjectives_Fragment;
import com.example.finalproject.AboutCollege.CollegeStrategy_Fragment;
import com.example.finalproject.AboutCollege.CollegeVision_Fragment;
import com.example.finalproject.R;
import com.example.finalproject.courses.Java_Fragment;

public class AboutCollegeFragment extends Fragment {
    Button college_vision , college_strategy , college_objectives , college_departments ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about_college, container, false);

        college_vision = view.findViewById(R.id.college_vision);
        college_strategy = view.findViewById(R.id.college_strategy);
        college_objectives = view.findViewById(R.id.college_objectives);
        college_departments = view.findViewById(R.id.college_departments);

        college_vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment vision = new CollegeVision_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, vision)
                        .addToBackStack(null)
                        .commit();
            }
        });

        college_strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment strategy = new CollegeStrategy_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, strategy)
                        .addToBackStack(null)
                        .commit();
            }
        });

        college_objectives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment collegeObjectives = new CollegeObjectives_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, collegeObjectives)
                        .addToBackStack(null)
                        .commit();
            }
        });

        college_departments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment collegeDepartments = new CollegeDepartments_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, collegeDepartments )
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}