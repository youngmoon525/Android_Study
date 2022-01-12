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

import com.example.mockupproject.DTO.Home_Rec1DTO;
import com.example.mockupproject.R;

import java.util.ArrayList;

public class Home_Adapter_Rec1 extends RecyclerView.Adapter<Home_Adapter_Rec1.ViewHolder> {
    Context context;
    ArrayList<Home_Rec1DTO> list;
    LayoutInflater inflater;

    public Home_Adapter_Rec1(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Home_Adapter_Rec1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.item_home_rec1, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Adapter_Rec1.ViewHolder holder, int position) {
       // holder.binding(holder, position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout home_rec1_linear;
        ImageView home_rec1_img1;
        TextView home_rec1_tv1, home_rec1_tv2, home_rec1_tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rec1_linear = itemView.findViewById(R.id.home_rec1_linear);
            home_rec1_img1 = itemView.findViewById(R.id.home_rec1_img1);
            home_rec1_tv1 = itemView.findViewById(R.id.home_rec1_tv1);
            home_rec1_tv2 = itemView.findViewById(R.id.home_rec1_tv2);
            home_rec1_tv3 = itemView.findViewById(R.id.home_rec1_tv3);

            home_rec1_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "페이지이동", Toast.LENGTH_SHORT).show();
                }
            });
        }
       /* public void binding(ViewHolder holder, int position){
            holder.home_rec1_img1.setImageResource(list.get(position).getHome_rec1_img1());
            holder.home_rec1_tv1.setText(list.get(position).getHome_rec1_tv1());
            holder.home_rec1_tv2.setText(list.get(position).getHome_rec1_tv2());
            holder.home_rec1_tv3.setText(list.get(position).getHome_rec1_tv3());
        }*/
    }
}
