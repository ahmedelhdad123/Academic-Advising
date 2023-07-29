package com.example.finalproject.AboutCollege;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.CalculateGPA.Six_Subjects;
import com.example.finalproject.HomeFragment.AboutCollegeFragment;
import com.example.finalproject.Info_college.Bio;
import com.example.finalproject.Info_college.Cs;
import com.example.finalproject.Info_college.Is;
import com.example.finalproject.Info_college.It;
import com.example.finalproject.Info_college.Soft;
import com.example.finalproject.R;

public class CollegeDepartments_Fragment extends Fragment {
    ImageView iv_back ;
    TextView Cs , It , Is , Bio ,  Soft ;

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_college_departments_, container, false);

        iv_back = view.findViewById(R.id.arrow_back);
        Cs = view.findViewById(R.id.CS);
        It = view.findViewById(R.id.IT);
        Is = view.findViewById(R.id.IS);
        Bio = view.findViewById(R.id.BIO);
        Soft = view.findViewById(R.id.SOFT);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment college_fragment = new AboutCollegeFragment();
                fragmentTransaction.setCustomAnimations(
                        R.anim.fade_in,     // exit
                        R.anim.slide_out,  // enter
                        R.anim.fade_in,   // exit
                        R.anim.slide_out // enter
                )
                        .replace(R.id.fragment_container, college_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Cs = new Cs();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, Cs)
                        .addToBackStack(null)
                        .commit();
            }
        });

        It.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment It = new It();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, It)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Is = new Is();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, Is)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Bio = new Bio();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, Bio)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Soft = new Soft();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, Soft)
                        .addToBackStack(null)
                        .commit();
            }
        });



        return view;
    }
}