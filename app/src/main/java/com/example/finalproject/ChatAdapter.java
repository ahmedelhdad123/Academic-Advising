package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;



import static com.example.finalproject.SharedPreferencesManger.LoadData;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {


    private Context context;
    private ChatActivity activity;
    private ArrayList<ChatMessage> restaurantDataList = new ArrayList<>();
    static final int LEFT_RECEIVE = 0;
    static final int RIGHT_SEND = 1;



    public ChatAdapter(Context context, ChatActivity activity, ArrayList<ChatMessage> restaurantDataList) {
        this.context = context;
        this.activity = activity;
        this.restaurantDataList = restaurantDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RIGHT_SEND) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_send,
                    parent, false);
            return new ViewHolder(view);

        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_receive,
                    parent, false);
            return new ViewHolder(view);

        }


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {


        holder.keyMessage.setText(restaurantDataList.get(position).getMessage());



    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return restaurantDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        TextView keyMessage;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            keyMessage=view.findViewById(R.id.item_chat_tV_message);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (restaurantDataList.get(position).getSender().equals(LoadData(activity , "name"))) {
            return RIGHT_SEND;
        } else {
            return LEFT_RECEIVE;
        }
    }
    public String convertDate(String dateInMilliseconds, String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }
}
