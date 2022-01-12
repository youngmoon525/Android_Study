package com.example.frip.Pager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frip.R;

import java.util.ArrayList;


public class Pager2Adapter extends RecyclerView.Adapter<Pager2Adapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<Pager2DTO> list;


    public Pager2Adapter(Context context,ArrayList<Pager2DTO> list) {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.pager2_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Pager2Adapter.ViewHolder holder, int position) {
        holder.binding(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv2;
        ImageView imgv2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv2 = itemView.findViewById(R.id.imgv2);
            tv2 = itemView.findViewById(R.id.tv2);

        }



        public void binding(ViewHolder holder, int position){
            holder.tv2.setText(list.get(position).getTv2());
            holder.imgv2.setImageResource(list.get(position).getImgv2());
        }






    }






}
