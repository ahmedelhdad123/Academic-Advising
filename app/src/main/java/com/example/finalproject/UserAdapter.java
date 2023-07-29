package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.HomeFragment.ChatFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private Context context;
    private List<String> userModelList;

    public UserAdapter(Context context) {
        this.context = context;
        userModelList=new ArrayList<>();

    }


    public void add(String userModel){
        userModelList.add(userModel);
        notifyDataSetChanged();
    }

    public void clear(){
        userModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String userModel=userModelList.get(position);
        if (userModelList != null && userModelList.get(position) != null) {

            // UserModel currentUser = userModelList.get(position);
            holder.name.setText(userModel);


        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String username = userModelList.get(position);

                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("username", username);
                context.startActivity(intent);
            }
        });

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ChatActivity.class);
                intent.putExtra("id",userModel.getUserId());
                context.startActivity(intent);
                /*int position = holder.getAdapterPosition();
                if (userModelList != null && userModelList.get(position) != null) {
                    UserModel currentUser = userModelList.get(position);
                    String userId = currentUser.getUserId();
                }
            }
        })*/
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.userName);


        }
    }

}