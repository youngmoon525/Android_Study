package com.example.mozak.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mozak.Pager2.Pager2Adapter;
import com.example.mozak.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    Context context;
    ArrayList<RecyclerDTO> list;
    LayoutInflater inflater;

    public RecyclerAdapter(Context context, ArrayList<RecyclerDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.recycleritem, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rec_tv_id.setText("user"+position + 1);
        holder.rec_tv_text.setText("user"+ position +1 +"가 작성한 내용입니다.");
        Pager2Adapter pager2Adapter = new Pager2Adapter(context);
        holder.rec_pager2_img.setAdapter(pager2Adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rec_tv_id, rec_tv_text;
        ViewPager2 rec_pager2_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_tv_id = itemView.findViewById(R.id.rec_tv_id);
            rec_tv_text = itemView.findViewById(R.id.rec_tv_text);
            rec_pager2_img = itemView.findViewById(R.id.rec_pager2_img);

        }
    }
}
