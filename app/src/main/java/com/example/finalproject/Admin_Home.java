package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.finalproject.Admin.create_email_fragment;
import com.example.finalproject.Admin.create_post_fragment;

public class Admin_Home extends AppCompatActivity {
    Button btn_post , btn_create_group , btn_edit_group , btn_delete_group , btn_create_email , btn_log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        btn_create_group = (Button) findViewById(R.id.admin_create_group);
        btn_edit_group = (Button) findViewById(R.id.admin_edit_group);
        btn_delete_group = (Button) findViewById(R.id.admin_delete_group);
        btn_create_email = (Button) findViewById(R.id.admin_add_user);
        btn_post = (Button) findViewById(R.id.admin_post);
        btn_log_out = (Button) findViewById(R.id.admin_out);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment create_post = new create_post_fragment();
                fragmentTransaction.replace(R.id.fragment_container_admin,create_post).commit();

                   //to hide all buttons from admin_home
                btn_post.setVisibility(View.GONE);
                btn_create_group.setVisibility(View.GONE);
                btn_edit_group.setVisibility(View.GONE);
                btn_delete_group.setVisibility(View.GONE);
                btn_create_email.setVisibility(View.GONE);
                btn_log_out.setVisibility(View.GONE);
            }
        });

        btn_create_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment create_email = new create_email_fragment();
                fragmentTransaction.replace(R.id.fragment_container_admin,create_email).commit();

                //to hide all buttons from admin_home
                btn_post.setVisibility(View.GONE);
                btn_create_group.setVisibility(View.GONE);
                btn_edit_group.setVisibility(View.GONE);
                btn_delete_group.setVisibility(View.GONE);
                btn_create_email.setVisibility(View.GONE);
                btn_log_out.setVisibility(View.GONE);
            }
        });

        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Login_Page.class);
                startActivity(intent);
            }
        });
    }
}