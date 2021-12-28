package com.example.new03_recyclerpager.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new03_recyclerpager.R;
import com.example.new03_recyclerpager.recycler.RecTestAdapter;

public class Pager2Adapter extends RecyclerView.Adapter<Pager2Adapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    public Pager2Adapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycleritem2 , parent , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    //1. Viewholder라는 클래스(widget들을 한번에 묶어놓을수있는) 만드는것.
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
