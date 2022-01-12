package com.hanul.busapp.favorite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.hanul.busapp.R;
import com.hanul.busapp.bus.BusVO;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<BusVO> list;

    public TestAdapter(Context context,ArrayList<BusVO> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.fav_route_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.favRoute_stn.setText(list.get(position).getStation());
        holder.favRoute_rt.setText(list.get(position).getRoute());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView favRoute_stn, favRoute_rt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            favRoute_stn = itemView.findViewById(R.id.favRoute_stn);
            favRoute_rt = itemView.findViewById(R.id.favRoute_rt);
        }
    }
}
