package com.example.finalproject.CalculateGPA;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.HomeFragment.Calc_GpaFragment;
import com.example.finalproject.R;

import java.util.Locale;


public class Five_Subjects extends Fragment {
    private EditText subject1EditText;
    private EditText subject2EditText;
    private EditText subject3EditText;
    private EditText subject4EditText;
    private EditText subject5EditText;
    private TextView resultTextView;
    private Button calculateButton;

    ////////////////////////////////
    public Five_Subjects() {
        // Required empty public constructor
    }
    /////////////////////////////////////////

    ImageView iv_back;

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
        View view =inflater.inflate(R.layout.fragment_five__subjects, container, false);

        iv_back = view.findViewById(R.id.arrow_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Gpa_fragment = new Calc_GpaFragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.fade_in,     // exit
                                R.anim.slide_out,  // enter
                                R.anim.fade_in,   // exit
                                R.anim.slide_out // enter
                        )
                        .replace(R.id.fragment_container,Gpa_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
//////////////////////////////////////////////////////////////////////
        subject1EditText = view.findViewById(R.id.subject1EditText);
        subject2EditText = view.findViewById(R.id.subject2EditText);
        subject3EditText = view.findViewById(R.id.subject3EditText);
        subject4EditText = view.findViewById(R.id.subject4EditText);
        subject5EditText = view.findViewById(R.id.subject5EditText);
        calculateButton = view.findViewById(R.id.calculateButton);
        resultTextView = view.findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double subject1GPA = calculateGPA(subject1EditText.getText().toString());
                double subject2GPA = calculateGPA(subject2EditText.getText().toString());
                double subject3GPA = calculateGPA(subject3EditText.getText().toString());
                double subject4GPA = calculateGPA(subject4EditText.getText().toString());
                double subject5GPA = calculateGPA(subject5EditText.getText().toString());

                double totalGPA = ((subject1GPA + subject2GPA + subject3GPA + subject4GPA + subject5GPA ) * 3 )/15;
                String resultText = String.format(Locale.getDefault(), "Your GPA is %.2f", totalGPA);

                resultTextView.setText(resultText);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////

        return view;
    }

    private double calculateGPA(String grade) {
        if (TextUtils.isEmpty(grade)) {
            return 0.0;
        }

        double numericGrade = Double.parseDouble(grade);
        if (numericGrade >= 90 && numericGrade<=100) {
            return 4.0;
        } else if (numericGrade >= 85 && numericGrade < 90) {
            return 3.7;
        } else if (numericGrade >= 80 && numericGrade < 85) {
            return 3.3;
        } else if (numericGrade >= 75 && numericGrade<80) {
            return 3.0;
        } else if (numericGrade >= 70 && numericGrade<75) {
            return 2.7;
        } else if (numericGrade >= 65 && numericGrade<70) {
            return 2.4;
        } else if (numericGrade >= 60 && numericGrade<65) {
            return 2.2;
        } else if (numericGrade >= 50 && numericGrade<60) {
            return 2.0;
        } else {
            return 0.0;
        }
    }
}