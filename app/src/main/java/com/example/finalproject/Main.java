package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.example.finalproject.HomeFragment.AAuFragment;
import com.example.finalproject.HomeFragment.AboutCollegeFragment;
import com.example.finalproject.HomeFragment.Calc_GpaFragment;
import com.example.finalproject.HomeFragment.CoursesFragment;
import com.example.finalproject.HomeFragment.TimeLineFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import  static com.example.finalproject.SharedPreferencesManger.SaveData;
import  static com.example.finalproject.SharedPreferencesManger.LoadData;
public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private String userName;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    TextView signupName;
    TextView signupEmail;
    TextView signupNameStaff;
    TextView signupEmailStaff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //==================================== button back

        //=====================================  navigation drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        /////////////////////////////////////////////////////////////////
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        signupName =navigationView.getHeaderView(0).findViewById(R.id.header_username);
        signupEmail =(TextView) navigationView.getHeaderView(0).findViewById(R.id.user_email);
        userName=getIntent().getExtras().getString("email");
        signupName.setText(userName);
        getInfo();
        ///////////////////////////////////////////////////////////////////
        signupNameStaff =navigationView.getHeaderView(0).findViewById(R.id.header_username);
        signupEmailStaff =(TextView) navigationView.getHeaderView(0).findViewById(R.id.user_email);
        userName=getIntent().getExtras().getString("email");
        signupNameStaff.setText(userName);
        getInfoStaff();
        ///////////////////////////////////////////////////////////////////
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TimeLineFragment()).commit();
            navigationView.setCheckedItem(R.id.timeline);
        }
    }
    public void getInfo()
    {
        databaseReference.child("student").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot sp:snapshot.getChildren())
                {
                    HashMap<String, String> info = (HashMap<String, String>) sp.getValue();
                    if (info != null) {
                        String name = info.get("signupName");
                        String userEmail = info.get("signupEmail");
                        if(name.equals(userName))
                        {
                            signupEmail.setText(userEmail);
                            SaveData(Main.this,"name",name);
                            SaveData(Main.this,"email",userEmail);

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void getInfoStaff()
    {
        databaseReference.child("staff").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot sp:snapshot.getChildren())
                {
                    HashMap<String, String> infoStaff = (HashMap<String, String>) sp.getValue();
                    if (infoStaff != null) {
                        String name = infoStaff.get("signupNameStaff");
                        String userEmail = infoStaff.get("signupEmailStaff");
                        if(name != null && name.equals(userName))
                        {
                            signupEmail.setText(userEmail);
                            SaveData(Main.this,"name",name);
                            SaveData(Main.this,"email",userEmail);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.timeline:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TimeLineFragment()).commit();
                break;
            case R.id.Chat:
                Intent intentt=new Intent(Main.this, ChatMainActivity.class);
                startActivity(intentt);
                finish();
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment()).commit();
                break;
            case R.id.calculate_gpa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Calc_GpaFragment()).commit();
                break;
            case R.id.AAu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AAuFragment()).commit();
                break;
            case R.id.about_college:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutCollegeFragment()).commit();
                break;
            case R.id.courses:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CoursesFragment()).commit();
                break;
            case R.id.logout:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,Login_Page.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//========================================================================================= button back

//==========================================================================================

}
