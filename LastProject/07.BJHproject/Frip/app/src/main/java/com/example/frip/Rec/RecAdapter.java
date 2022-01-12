package com.example.frip.Rec;

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

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    Context context;
    ArrayList<RecDTO> list;
    LayoutInflater inflater;


    public RecAdapter(Context context, ArrayList<RecDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    //3.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = inflater.inflate(R.layout.rec_item,parent,false);


        return new ViewHolder(itemView);
    }




    //4.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding(holder,position);

    }

    //5.
    @Override
    public int getItemCount() {
        return list.size();
    }


    //1.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv1;
        TextView tv1;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imgv1 = itemView.findViewById(R.id.imgv1);
            tv1 = itemView.findViewById(R.id.tv1);

        }


        public void binding(ViewHolder holder, int position){
            holder.tv1.setText(list.get(position).getTv1());
            holder.imgv1.setImageResource(list.get(position).getImgv1());
        }



    }

}
