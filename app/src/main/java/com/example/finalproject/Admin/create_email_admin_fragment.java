package com.example.finalproject.Admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.courses.Java_Fragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class create_email_admin_fragment extends Fragment {

    ImageView iv_back;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalproject-c5810-default-rtdb.firebaseio.com/");
    EditText signupNameAdmin ,signupEmailAdmin ,signupPasswordAdmin;
    Button save_btn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_create_email_admin_fragment, container, false);

        signupNameAdmin = view.findViewById(R.id.name_create_admin);
        signupEmailAdmin = view.findViewById(R.id.email_create_admin);
        signupPasswordAdmin = view.findViewById(R.id.password_create_admin);
        save_btn2 = view.findViewById(R.id.signup_create_admin);

        save_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signupNameAdmin.getText().toString();
                String email = signupEmailAdmin.getText().toString();
                String password = signupPasswordAdmin.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("admin").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(name)){
                                Toast.makeText(getActivity(), "email is already created", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("admin").child(name).child("signupEmailAdmin").setValue(email);
                                databaseReference.child("admin").child(name).child("signupNameAdmin").setValue(name);
                                databaseReference.child("admin").child(name).child("signupPasswordAdmin").setValue(password);
                                Toast.makeText(getActivity(), "You have save successfully", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });


        iv_back = view.findViewById(R.id.arrow_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment email_main = new create_email_fragment();
                fragmentTransaction.replace(R.id.fragment_container_admin,email_main).commit();
            }
        });
        return view;
    }
}