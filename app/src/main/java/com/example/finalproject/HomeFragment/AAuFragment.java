package com.example.finalproject.HomeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.AAU.Mission;
import com.example.finalproject.AAU.Objectives;
import com.example.finalproject.AAU.Approach;
import com.example.finalproject.R;

public class AAuFragment extends Fragment {
    Button mission , objectives , regulations ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aau, container, false);

        mission = view.findViewById(R.id.aau_mission);
        objectives = view.findViewById(R.id.aau_objectives);
        regulations = view.findViewById(R.id.aau_regulation);

        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment mission = new Mission();
                fragmentTransaction.replace(R.id.fragment_container,mission).commit();*/

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment mission = new Mission();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, mission)
                        .addToBackStack(null)
                        .commit();
            }
        });

        objectives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment objectives = new Objectives();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, objectives)
                        .addToBackStack(null)
                        .commit();
            }
        });

        regulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment regulations = new Approach();
                fragmentTransaction.setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.slide_in,  // enter
                                R.anim.fade_out // exit
                        )
                        .replace(R.id.fragment_container, regulations)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}