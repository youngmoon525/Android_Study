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

public class RecEventAdapter extends RecyclerView.Adapter<RecEventAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecEventDTO> list;

    public RecEventAdapter(Context context, ArrayList<RecEventDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_event_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.event_img.setImageResource(list.get(position).getRes_img());
        holder.tag.setText(list.get(position).getTag());
        holder.subject.setText(list.get(position).getSubject());
        holder.location.setText(list.get(position).getLocation());
        holder.member.setText(list.get(position).getMember());
        holder.time.setText(list.get(position).getTime());
        holder.clock.setText(list.get(position).getClock());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView event_img;
        public TextView tag, subject, location, member, time, clock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.event_img = itemView.findViewById(R.id.event_img);
            this.tag = itemView.findViewById(R.id.event_tag);
            this.subject = itemView.findViewById(R.id.event_subject);
            this.location = itemView.findViewById(R.id.event_location);
            this.member = itemView.findViewById(R.id.event_member);
            this.time = itemView.findViewById(R.id.event_time);
            this.clock = itemView.findViewById(R.id.event_clock);
        }
    }
}
