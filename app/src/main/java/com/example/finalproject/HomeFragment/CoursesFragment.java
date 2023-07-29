package com.example.finalproject.HomeFragment;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.R;
import com.example.finalproject.courses.Android_Fragment;
import com.example.finalproject.courses.Java_Fragment;
import com.example.finalproject.courses.cpp_Fragment;

public class CoursesFragment extends Fragment {
     Button java_map  , cpp_map , android_map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_courses, container, false);

        java_map =root.findViewById(R.id.java_map);
        cpp_map = root.findViewById(R.id.cpp_map);
        android_map = root.findViewById(R.id.android_map);

        java_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment java = new Java_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, java)
                        .addToBackStack(null)
                        .commit();
            }
        });

        cpp_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment cpp = new cpp_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, cpp)
                        .addToBackStack(null)
                        .commit();
            }
        });

        android_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment android = new Android_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, android)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return root;
    }
}