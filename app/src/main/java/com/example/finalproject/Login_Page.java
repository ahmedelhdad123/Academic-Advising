package com.example.finalproject;

import static com.example.finalproject.SharedPreferencesManger.SaveData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;
import  static com.example.finalproject.SharedPreferencesManger.SaveData;


public class Login_Page extends AppCompatActivity {

    private RadioGroup radioGroup ;
    private RadioButton radioButton;
    private EditText username, Password ;
    private TextView need_help ;
    private Button sign_in ;
    TextView signupEmail;
    private String userName;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalproject-c5810-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        radioGroup = findViewById(R.id.radio_group);
        username = findViewById(R.id.email_login);
        Password = findViewById(R.id.password);
        need_help = findViewById(R.id.need_help);
        sign_in = findViewById(R.id.btn_sign_in);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);
                switch (radioButton.getId()){
                    case R.id.student_id:
                    {
                        SaveData(Login_Page.this,"type","student");

                        /*sign_in.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(Login_Page.this, Main.class));
                            }
                        });*/
                        sign_in.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String userTxt = username.getText().toString();
                                String passwordTxt = Password.getText().toString();


                                if(userTxt.isEmpty() || passwordTxt.isEmpty()){
                                    Toast.makeText(Login_Page.this, "Please enter your email or pass", Toast.LENGTH_SHORT).show();

                                }
                                else {
                                    databaseReference.child("student").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.hasChild(userTxt)){
                                                final String getPassword =snapshot.child(userTxt).child("signupPassword").getValue(String.class);

                                                if (getPassword.equals(passwordTxt)){
                                                    Toast.makeText(Login_Page.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                                    Intent intent=new Intent(Login_Page.this, Main.class);
                                                    intent.putExtra("email",username.getText().toString());
                                                    startActivity(intent);
                                                    finish();
                                                }
                                                else {
                                                    Toast.makeText(Login_Page.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            else {
                                                Toast.makeText(Login_Page.this, "Wrong email", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }
                            }
                        });
                    }
                    break;
                    case R.id.staff_id:
                    {
                        SaveData(Login_Page.this,"type","staff");

                        sign_in.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String userTxtStaff = username.getText().toString();
                                String passwordTxtStaff = Password.getText().toString();

                                if(userTxtStaff.isEmpty() || passwordTxtStaff.isEmpty()){
                                    Toast.makeText(Login_Page.this, "Please enter your email or pass", Toast.LENGTH_SHORT).show();

                                }
                                else {
                                    databaseReference.child("staff").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.hasChild(userTxtStaff)){
                                                final String getPassword =snapshot.child(userTxtStaff).child("signupPasswordStaff").getValue(String.class);

                                                if (getPassword.equals(passwordTxtStaff)){
                                                    Toast.makeText(Login_Page.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                                    Intent intent=new Intent(Login_Page.this, Main.class);
                                                    intent.putExtra("email",username.getText().toString());
                                                    //Toast.makeText(Login_Page.this , username.getText().toString() , Toast.LENGTH_SHORT).show();
                                                    startActivity(intent);
                                                    finish();
                                                }
                                                else {
                                                    Toast.makeText(Login_Page.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            else {
                                                Toast.makeText(Login_Page.this, "Wrong email", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }
                            }
                        });
                    }
                    break;
                    case R.id.admin_id:
                    {
                        /*sign_in.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(Login_Page.this, Main.class));
                            }
                        });*/
                        sign_in.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String userTxtAdmin = username.getText().toString();
                                String passwordTxtAdmin = Password.getText().toString();

                                if(userTxtAdmin.isEmpty() || passwordTxtAdmin.isEmpty()){
                                    Toast.makeText(Login_Page.this, "Please enter your email or pass", Toast.LENGTH_SHORT).show();

                                }
                                else {
                                    databaseReference.child("admin").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.hasChild(userTxtAdmin)){
                                                final String getPassword =snapshot.child(userTxtAdmin).child("signupPasswordAdmin").getValue(String.class);

                                                if (getPassword.equals(passwordTxtAdmin)){
                                                    Toast.makeText(Login_Page.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(Login_Page.this,Admin_Home.class));
                                                    finish();
                                                }
                                                else {
                                                    Toast.makeText(Login_Page.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            else {
                                                Toast.makeText(Login_Page.this, "Wrong email", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }
                            }
                        });
                    }
                   // break;
                   // default:

                }
            }
        });


        // another code for realtime
        /*sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateEmail() | !validatePassword()){

                }else {
                    checkUser();
                }
            }
        });
    }
    public Boolean validateEmail() {
        String val = username.getText().toString();
        if (val.isEmpty()) {
            username.setError("Email cannot be empty");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }
    public Boolean validatePassword() {
        String val = Password.getText().toString();
        if (val.isEmpty()) {
            Password.setError("Password cannot be empty");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = username.getText().toString().trim();
        String userPassword = Password.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("signupName").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.setError(null);
                    String passwordFromDB =snapshot.child(userUsername).child("signupPassword").getValue(String.class);
                    if(!Objects.equals(passwordFromDB,userPassword)){
                        username.setError(null);
                        Intent intent=new Intent(Login_Page.this,Main.class);
                        startActivity(intent);
                    }else {
                        Password.setError("Invalid Credentials");
                        Password.requestFocus();
                    }
                }else{
                    username.setError("User dose not exist");
                    username.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        // The basic code for realtime
        /*sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userTxt = username.getText().toString();
                String passwordTxt = Password.getText().toString();

                if(userTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login_Page.this, "Please enter your email or pass", Toast.LENGTH_SHORT).show();

                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(userTxt)){
                                final String getPassword =snapshot.child(userTxt).child("signupPassword").getValue(String.class);

                                if (getPassword.equals(passwordTxt)){
                                    Toast.makeText(Login_Page.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login_Page.this,Main.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(Login_Page.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Login_Page.this, "Wrong email3", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });*/

        need_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Page.this,problem_Page.class));
            }
        });
    }
}
