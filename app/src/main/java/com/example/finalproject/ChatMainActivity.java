package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.UserAdapter;
import com.example.finalproject.UserModel;
import com.example.finalproject.databinding.ActivityChatMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import  static com.example.finalproject.SharedPreferencesManger.LoadData;
public class ChatMainActivity extends AppCompatActivity {

    ActivityChatMainBinding binding;
    DatabaseReference databaseReference;
    UserAdapter userAdapter;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        userAdapter=new UserAdapter(this);

        binding.recycler.setAdapter(userAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        type = LoadData(ChatMainActivity.this , "type");
        if(type.equals("student"))
        {
            getStaff();
        } else if (type.equals("staff")) {
            getStudents();

        }





    }

    public void getStudents()
    {
        userAdapter.clear();
        userAdapter.notifyDataSetChanged();
        databaseReference= FirebaseDatabase.getInstance().getReference("student");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userAdapter.clear();
                for (DataSnapshot  dataSnapshot:snapshot.getChildren()){
                    String uName = dataSnapshot.getKey();
                    userAdapter.add(uName);
                    userAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void getStaff()
    {
        userAdapter.clear();
        userAdapter.notifyDataSetChanged();
        databaseReference= FirebaseDatabase.getInstance().getReference("staff");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot  dataSnapshot:snapshot.getChildren()){
                    String uName = dataSnapshot.getKey();
                    userAdapter.add(uName);
                    userAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        userAdapter.clear();
        userAdapter.notifyDataSetChanged();
        if(type.equals("student"))
        {
            getStaff();
        } else if (type.equals("staff")) {
            getStudents();

        }

    }
}