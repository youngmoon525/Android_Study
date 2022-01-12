package com.example.mockupproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mockupproject.DTO.Video_Pager1DTO;
import com.example.mockupproject.R;

import java.util.ArrayList;

public class Video_Adapter_Pager2 extends RecyclerView.Adapter<Video_Adapter_Pager2.ViewHolder>{
    Context context;
    ArrayList<Video_Pager1DTO> list;
    LayoutInflater inflater;

    public Video_Adapter_Pager2(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Video_Adapter_Pager2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.item_video_pager2, parent, false);
        return new Video_Adapter_Pager2.ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.binding(holder, position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout video_pager2_linear;
        ImageView video_pager2_img1;
        TextView video_pager2_tv1, video_pager2_tv2, video_pager2_tv3, video_pager2_tv4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video_pager2_linear = itemView.findViewById(R.id.video_pager2_linear);
            video_pager2_img1 = itemView.findViewById(R.id.video_pager2_img1);
            video_pager2_tv1 = itemView.findViewById(R.id.video_pager2_tv1);
            video_pager2_tv2 = itemView.findViewById(R.id.video_pager2_tv2);
            video_pager2_tv3 = itemView.findViewById(R.id.video_pager2_tv3);
            video_pager2_tv4 = itemView.findViewById(R.id.video_pager2_tv4);

            video_pager2_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "페이지이동", Toast.LENGTH_SHORT).show();
                }
            });
        }
      /*  public void binding(Home_Adapter_Rec5.ViewHolder holder, int position){
            holder.home_rec5_img1.setImageResource(list.get(position).getHome_rec5_img1());

            holder.home_rec5_tv1.setText(list.get(position).getHome_rec5_tv1());
            holder.home_rec5_tv2.setText(list.get(position).getHome_rec5_tv2());
            holder.home_rec5_tv3.setText(list.get(position).getHome_rec5_tv3());


        }*/
    }
}
