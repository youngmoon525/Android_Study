package com.example.frip.Frag2;

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

public class KateAdapter extends RecyclerView.Adapter<KateAdapter.ViewHolder> {
    Context context;
    ArrayList<KateDTO> list;
    LayoutInflater inflater;


    public KateAdapter(Context context, ArrayList<KateDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    //3.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = inflater.inflate(R.layout.kategorie_item,parent,false);


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
        ImageView kate_imgv1;
        ImageView kate_imgv2;
        TextView kate_tv1;
        TextView kate_tv2;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            kate_imgv1 = itemView.findViewById(R.id.kate_imgv1);
            kate_imgv2 = itemView.findViewById(R.id.kate_imgv2);
            kate_tv1 = itemView.findViewById(R.id.kate_tv1);
            kate_tv2 = itemView.findViewById(R.id.kate_tv2);

        }


        public void binding(KateAdapter.ViewHolder holder, int position){
            holder.kate_tv1.setText(list.get(position).getKate_tv1());
            holder.kate_tv2.setText(list.get(position).getKate_tv2());
            holder.kate_imgv1.setImageResource(list.get(position).getKate_imgv1());
            holder.kate_imgv2.setImageResource(list.get(position).getKate_imgv2());
        }



    }
}