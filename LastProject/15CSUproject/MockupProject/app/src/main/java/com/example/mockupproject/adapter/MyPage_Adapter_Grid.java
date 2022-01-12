package com.example.mockupproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mockupproject.R;

import java.util.ArrayList;

public class MyPage_Adapter_Grid extends BaseAdapter {
    Context context;
    ArrayList<Integer> glist;
    LayoutInflater inflater;

    public MyPage_Adapter_Grid(Context context, ArrayList<Integer> glist) {
        this.context = context;
        this.glist = glist;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return glist.size();
    }

    @Override
    public Object getItem(int position) {
        return glist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_mypage_grid, parent, false);
            holder = new GridViewHolder();
            holder.imgv = convertView.findViewById(R.id.mypage_grid_imgv);

            convertView.setTag(holder);
        } else {
            holder = (GridViewHolder) convertView.getTag();
        }

        holder.imgv.setImageResource(glist.get(position));

        holder.imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public class GridViewHolder{
        public ImageView imgv;
    }
}
