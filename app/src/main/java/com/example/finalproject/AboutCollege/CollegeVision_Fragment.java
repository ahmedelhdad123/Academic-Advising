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

import com.example.finalproject.HomeFragment.AboutCollegeFragment;
import com.example.finalproject.R;

public class CollegeVision_Fragment extends Fragment {
    ImageView iv_back ;
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
        View view = inflater.inflate(R.layout.fragment_college_vision, container, false);

        iv_back = view.findViewById(R.id.arrow_back);

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
                        .replace(R.id.fragment_container,college_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}