package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class problem_Page extends AppCompatActivity {

    private EditText email , name , id , problem ;
    private Button send ;
    private TextView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_page);

        email = findViewById(R.id.email_problem);
        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        problem = findViewById(R.id.problem);
        send = findViewById(R.id.btn_send);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(problem_Page.this,Login_Page.class));
            }
        });
    }
}