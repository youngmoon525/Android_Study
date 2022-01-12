package com.example.mockupproject.transactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mockupproject.R;

import java.util.ArrayList;

public class TransPagerAdapter extends RecyclerView.Adapter<TransPagerAdapter.ViewHolder>{
    Context context;
    LayoutInflater inflater;
    ArrayList<Integer> list;

    public TransPagerAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TransPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.transpageritem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransPagerAdapter.ViewHolder holder, int position) {
        holder.binding(holder, position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView trans_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trans_img = itemView.findViewById(R.id.trans_img);
        }
        public void binding(ViewHolder holder, int position){
            if(position == 0){
                holder.trans_img.setImageResource(R.drawable.trans1);
            } else if(position == 1){
                holder.trans_img.setImageResource(R.drawable.trans2);
            } else if(position == 2){
                holder.trans_img.setImageResource(R.drawable.trans3);
            } else if(position == 3){
                holder.trans_img.setImageResource(R.drawable.trans4);
            }
        }
    }
}
