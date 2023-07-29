package com.example.finalproject.Admin;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.Admin_Home;
import com.example.finalproject.R;
import com.example.finalproject.UserModel;
import com.example.finalproject.courses.Java_Fragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class create_email_fragment extends Fragment {
    ImageView iv_back;
    TextView create_staff ,  create_admin ;
    //FirebaseDatabase database;
    //DatabaseReference reference;
    EditText signupName ,signupEmail ,signupPassword;
    Button save_btn;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalproject-c5810-default-rtdb.firebaseio.com/");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_create_email_fragment, container, false);

        create_staff = view.findViewById(R.id.create_email_staff);
        create_admin = view.findViewById(R.id.create_email_admin);
        iv_back = view.findViewById(R.id.arrow_back);

        signupName = view.findViewById(R.id.name_create_account);
        signupEmail = view.findViewById(R.id.email_create_account);
        signupPassword = view.findViewById(R.id.password_create_account);
        save_btn = view.findViewById(R.id.signup_create_account);

        /*save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();

                Student student = new Student(name,email, password);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                reference.child(name).setValue(student);


                Toast.makeText(getActivity(), "You have save successfully", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(getActivity(), create_email_fragment.class);
                //startActivity(intent);
            }
        });*/

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("student").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(name)){
                                Toast.makeText(getActivity(), "email is already created", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("student").child(name).child("signupEmail").setValue(email);
                                databaseReference.child("student").child(name).child("signupName").setValue(name);
                                databaseReference.child("student").child(name).child("signupPassword").setValue(password);
                                FirebaseAuth
                                        .getInstance()
                                        .createUserWithEmailAndPassword(email.trim(),password)
                                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                            @Override
                                            public void onSuccess(AuthResult authResult) {
                                                UserProfileChangeRequest userProfileChangeRequest=new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                                                FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                                                firebaseUser.updateProfile(userProfileChangeRequest);
                                                UserModel userModel=new UserModel(FirebaseAuth.getInstance().getUid(), name,email, password);
                                                databaseReference.child(FirebaseAuth.getInstance().getUid()).setValue(userModel);
                                            }
                                        });
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

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Admin_Home.class);
                startActivity(intent);
            }
        });

        create_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment create_email = new create_email_staff_fragment();
                fragmentTransaction.replace(R.id.fragment_container_admin,create_email).commit();
            }
        });

        create_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment create_email = new create_email_admin_fragment();
                fragmentTransaction.replace(R.id.fragment_container_admin,create_email).commit();
            }
        });
        return view;
    }
}