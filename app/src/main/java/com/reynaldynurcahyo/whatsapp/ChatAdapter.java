package com.reynaldynurcahyo.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private ArrayList<String> listName;
    private ArrayList<String> listChat;
    private ArrayList<Integer> listPhoto;

    public ChatAdapter(ArrayList<String> listName, ArrayList<String> listChat, ArrayList<Integer> listPhoto) {
        this.listName = listName;
        this.listChat = listChat;
        this.listPhoto = listPhoto;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Glide.with(holder.getCivPhoto())
                .asBitmap()
                .load(listPhoto.get(position))
                .into(holder.civPhoto);
        holder.getTvUsername().setText(listName.get(position));
        holder.getTvChat().setText(listChat.get(position));

        holder.getRelativeLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), listName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listName.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civPhoto;
        TextView tvUsername, tvChat;
        RelativeLayout relativeLayout;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            civPhoto = itemView.findViewById(R.id.item_photo);
            tvUsername = itemView.findViewById(R.id.item_name);
            tvChat = itemView.findViewById(R.id.item_chat);
            relativeLayout = itemView.findViewById(R.id.chat_layout);
        }

        public CircleImageView getCivPhoto() {
            return civPhoto;
        }

        public TextView getTvUsername() {
            return tvUsername;
        }

        public TextView getTvChat() {
            return tvChat;
        }

        public RelativeLayout getRelativeLayout() {
            return relativeLayout;
        }
    }
}
