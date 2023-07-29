package com.example.finalproject.Info_college;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.finalproject.AboutCollege.CollegeDepartments_Fragment;
import com.example.finalproject.R;

public class Soft extends Fragment {
    ImageView iv_back ;

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
        View view = inflater.inflate(R.layout.fragment_soft, container, false);
        iv_back = view.findViewById(R.id.arrow_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment College_Department = new CollegeDepartments_Fragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.fade_in,     // exit
                                R.anim.slide_out,  // enter
                                R.anim.fade_in,   // exit
                                R.anim.slide_out // enter
                        )
                        .replace(R.id.fragment_container,College_Department)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    }
}