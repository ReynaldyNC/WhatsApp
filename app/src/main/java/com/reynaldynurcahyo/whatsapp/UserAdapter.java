package com.reynaldynurcahyo.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ListViewHolder> {
    private ArrayList<User> listUser;

    public UserAdapter(ArrayList<User> list) {
        this.listUser = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chat, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User user = listUser.get(position);
        Glide.with(holder.itemView.getContext())
                .load(user.getPhoto())
                .apply(new RequestOptions().override(65, 65))
                .into(holder.imgPhoto);
        holder.tvUsername.setText(user.getUsername());
        holder.tvChat.setText(user.getChat());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvUsername, tvChat;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            tvUsername = itemView.findViewById(R.id.item_name);
            tvChat = itemView.findViewById(R.id.item_chat);
        }
    }
}
