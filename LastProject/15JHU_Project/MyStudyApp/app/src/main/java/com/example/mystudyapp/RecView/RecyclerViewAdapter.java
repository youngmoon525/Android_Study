package com.example.mystudyapp.RecView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystudyapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecDTO> list;

    public RecyclerViewAdapter(Context context, ArrayList<RecDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.room_img.setImageResource(list.get(position).getRes_img());
        holder.tag.setText(list.get(position).getTag());
        holder.subject.setText(list.get(position).getSubject());
        holder.location.setText(list.get(position).getLocation());
        holder.member.setText(list.get(position).getMember());
        holder.like.setText(list.get(position).getLike()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView room_img;
        public TextView tag, subject, location, member, like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.room_img = itemView.findViewById(R.id.room_img);
            this.tag = itemView.findViewById(R.id.room_tag);
            this.subject = itemView.findViewById(R.id.room_subject);
            this.location = itemView.findViewById(R.id.room_location);
            this.member = itemView.findViewById(R.id.room_member);
            this.like = itemView.findViewById(R.id.room_like);
        }
    }
}
