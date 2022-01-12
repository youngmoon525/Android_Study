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

import com.example.mockupproject.DTO.Home_Rec4DTO;
import com.example.mockupproject.R;

import java.util.ArrayList;

public class Home_Adapter_Rec4 extends RecyclerView.Adapter<Home_Adapter_Rec4.ViewHolder>{
    Context context;
    ArrayList<Home_Rec4DTO> list;
    LayoutInflater inflater;

    public Home_Adapter_Rec4(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Home_Adapter_Rec4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.item_home_rec4, parent, false);
        return new Home_Adapter_Rec4.ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Adapter_Rec4.ViewHolder holder, int position) {
       // holder.binding(holder, position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout home_rec4_linear;
        ImageView home_rec4_img1, home_rec4_img2, home_rec4_img3, home_rec4_img4, home_rec4_img5, home_rec4_img6;
        TextView home_rec4_tv1, home_rec4_tv2, home_rec4_tv3, home_rec4_tv4, home_rec4_tv5, home_rec4_tv6;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rec4_linear = itemView.findViewById(R.id.home_rec4_linear);
            home_rec4_img1 = itemView.findViewById(R.id.home_rec4_img1);
            home_rec4_img2 = itemView.findViewById(R.id.home_rec4_img2);
            home_rec4_img3 = itemView.findViewById(R.id.home_rec4_img3);
            home_rec4_img4 = itemView.findViewById(R.id.home_rec4_img4);
            home_rec4_img5 = itemView.findViewById(R.id.home_rec4_img5);
            home_rec4_img6 = itemView.findViewById(R.id.home_rec4_img6);

            home_rec4_tv1 = itemView.findViewById(R.id.home_rec4_tv1);
            home_rec4_tv2 = itemView.findViewById(R.id.home_rec4_tv2);
            home_rec4_tv3 = itemView.findViewById(R.id.home_rec4_tv3);
            home_rec4_tv4 = itemView.findViewById(R.id.home_rec4_tv4);
            home_rec4_tv5 = itemView.findViewById(R.id.home_rec4_tv5);
            home_rec4_tv6 = itemView.findViewById(R.id.home_rec4_tv6);


            home_rec4_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "페이지이동", Toast.LENGTH_SHORT).show();
                }
            });
        }
        /*public void binding(Home_Adapter_Rec4.ViewHolder holder, int position){
            holder.home_rec4_img1.setImageResource(list.get(position).getHome_rec4_img1());
            holder.home_rec4_img2.setImageResource(list.get(position).getHome_rec4_img1());
            holder.home_rec4_img3.setImageResource(list.get(position).getHome_rec4_img1());
            holder.home_rec4_img4.setImageResource(list.get(position).getHome_rec4_img1());
            holder.home_rec4_img5.setImageResource(list.get(position).getHome_rec4_img1());
            holder.home_rec4_img6.setImageResource(list.get(position).getHome_rec4_img1());

            holder.home_rec4_tv1.setText(list.get(position).getHome_rec4_tv1());
            holder.home_rec4_tv2.setText(list.get(position).getHome_rec4_tv2());
            holder.home_rec4_tv3.setText(list.get(position).getHome_rec4_tv3());
            holder.home_rec4_tv4.setText(list.get(position).getHome_rec4_tv4());
            holder.home_rec4_tv5.setText(list.get(position).getHome_rec4_tv5());
            holder.home_rec4_tv6.setText(list.get(position).getHome_rec4_tv6());

        }*/
    }
}
