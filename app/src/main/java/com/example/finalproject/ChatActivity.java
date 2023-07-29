package com.example.finalproject;

import static com.example.finalproject.SharedPreferencesManger.SaveData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.finalproject.databinding.ActivityChatBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import  static com.example.finalproject.SharedPreferencesManger.LoadData;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;
    String recieverId;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    DatabaseReference databaseReferenceSender,databaseReferenceReciever;
    TextView signupName;
    TextView signupEmail;
    TextView signupNameStaff;
    TextView signupEmailStaff;
    private String userName;
    String senderRoom,recieverRoom;
    MessageAdapter messageAdapter;

    String recieverUsername;
    String type;
    String uName;
    ArrayList <ChatMessage> list = new ArrayList<>();
    ChatAdapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // recieverId=getIntent().getStringExtra("id");

        userName = getIntent().getStringExtra("username");
        type = LoadData(ChatActivity.this , "type");
        uName = LoadData(ChatActivity.this , "name");


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();



//        senderRoom= FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+userName;
//        recieverRoom=userName+FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
//
//
//
//        messageAdapter=new MessageAdapter(this);
//        binding.recycler.setAdapter(messageAdapter);
//        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
//
//        databaseReferenceSender= FirebaseDatabase.getInstance().getReference("chats").child(senderRoom);
//        databaseReferenceReciever= FirebaseDatabase.getInstance().getReference("chats").child(recieverRoom);
//
//
//        databaseReferenceSender.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                messageAdapter.clear();
//                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//                    MessageModel messageModel=dataSnapshot.getValue(MessageModel.class);
//                   messageAdapter.add(messageModel);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        binding.sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=binding.messageEd.getText().toString();
                if (message.trim().length()>0){
                    sendMessage(message);

                }
            }
        });
        getChats();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatActivity.this);
        linearLayoutManager.setStackFromEnd(true);
        binding.recycler.setLayoutManager(linearLayoutManager);

        ///////////////////////////////////////////////////////
        /*database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

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
                            SaveData(ChatActivity.this,"name",name);
                            SaveData(ChatActivity.this,"email",userEmail);

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        /////////////////////////////////////////////////////

    }
    /*private void sendMessage(String message) {
        String messageId= UUID.randomUUID().toString();
        MessageModel messageModel=new MessageModel(messageId,FirebaseAuth.getInstance().getUid(),message);

        messageAdapter.add(messageModel);
        databaseReferenceSender
                .child(messageId)
                .setValue(messageModel);
        databaseReferenceReciever
                .child(messageId)
                .setValue(messageModel);

    }*/
    /*private void sendMessage(String message) {
        String senderUsername = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        MessageModel messageModel = new MessageModel(senderUsername, message);

        messageAdapter.add(messageModel);
        databaseReferenceSender
                .child(senderUsername)
                .setValue(messageModel);
        databaseReferenceReciever
                .child(senderUsername)
                .setValue(messageModel);
    }*/
    public void sendMessage(String message){
        HashMap<String ,String> map=new HashMap<>();
        map.put("message",message);
        map.put("sender",LoadData(ChatActivity.this,"name"));
        map.put("reciever",userName);
        binding.messageEd.setText("");

        if(type.equals("student"))
        {
            databaseReference.child("staff").child(userName).child("chats").push().setValue(map);
            databaseReference.child("student").child(LoadData(ChatActivity.this,"name")).child("chats").push().setValue(map);

        } else if (type.equals("staff")) {
            databaseReference.child("student").child(userName).child("chats").push().setValue(map);
            databaseReference.child("staff").child(LoadData(ChatActivity.this,"name")).child("chats").push().setValue(map);

        }

    }
    public void getChats()
    {
        list = new ArrayList<>();
        databaseReference.child(type).child(uName).child("chats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                    list.add(chatMessage);
                   // Toast.makeText(ChatActivity.this , list.size() , Toast.LENGTH_SHORT).show();

                }
                adapter = new ChatAdapter(ChatActivity.this , ChatActivity.this , list);
                binding.recycler.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}