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

import com.example.mockupproject.DTO.Home_Rec2DTO;
import com.example.mockupproject.R;

import java.util.ArrayList;

public class Home_Adapter_Rec2 extends RecyclerView.Adapter<Home_Adapter_Rec2.ViewHolder>{
    Context context;
    ArrayList<Home_Rec2DTO> list;
    LayoutInflater inflater;

    public Home_Adapter_Rec2(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Home_Adapter_Rec2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.item_home_rec2, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Adapter_Rec2.ViewHolder holder, int position) {
       // holder.binding(holder, position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout home_rec2_linear;
        ImageView home_rec2_img1, home_rec2_img2;
        TextView home_rec2_tv1, home_rec2_tv2, home_rec2_tv3, home_rec2_tv4, home_rec2_tv5, home_rec2_tv6, home_rec2_tv7;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rec2_linear = itemView.findViewById(R.id.home_rec2_linear);
            home_rec2_img1 = itemView.findViewById(R.id.home_rec2_img1);
            home_rec2_img2 = itemView.findViewById(R.id.home_rec2_img2);
            home_rec2_tv1 = itemView.findViewById(R.id.home_rec2_tv1);
            home_rec2_tv2 = itemView.findViewById(R.id.home_rec2_tv2);
            home_rec2_tv3 = itemView.findViewById(R.id.home_rec2_tv3);
            home_rec2_tv4 = itemView.findViewById(R.id.home_rec2_tv4);
            home_rec2_tv5 = itemView.findViewById(R.id.home_rec2_tv5);
            home_rec2_tv6 = itemView.findViewById(R.id.home_rec2_tv6);
            home_rec2_tv7 = itemView.findViewById(R.id.home_rec2_tv7);

            home_rec2_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "페이지이동", Toast.LENGTH_SHORT).show();
                }
            });
        }
       /* public void binding(ViewHolder holder, int position){
            holder.home_rec2_img1.setImageResource(list.get(position).getHome_rec2_img1());
            holder.home_rec2_img2.setImageResource(list.get(position).getHome_rec2_img2());
            holder.home_rec2_tv1.setText(list.get(position).getHome_rec2_tv1());
            holder.home_rec2_tv2.setText(list.get(position).getHome_rec2_tv2());
            holder.home_rec2_tv3.setText(list.get(position).getHome_rec2_tv3());
            holder.home_rec2_tv4.setText(list.get(position).getHome_rec2_tv4());
            holder.home_rec2_tv5.setText(list.get(position).getHome_rec2_tv5());
            holder.home_rec2_tv6.setText(list.get(position).getHome_rec2_tv6());
            holder.home_rec2_tv7.setText(list.get(position).getHome_rec2_tv7());
        }*/
    }
}
