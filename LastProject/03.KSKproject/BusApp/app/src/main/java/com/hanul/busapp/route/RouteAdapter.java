package com.hanul.busapp.route;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanul.busapp.R;
import com.hanul.busapp.bus.BusVO;

import java.util.ArrayList;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<BusVO> list;


    public RouteAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i < 20; i ++){
            BusVO vo1 = new BusVO(" 봉선37"," 송산유원지 ~ 월남동");
            BusVO vo2 = new BusVO(" 첨단95"," 첨단 ~ 시립제2요양병원");
            BusVO vo3 = new BusVO(" 수완12"," 무등산국립공원(증심사) ~ 돈보스코학교");
            BusVO vo4 = new BusVO(" 문흥39"," 장등동 ~ 국립광주과학관");
            BusVO vo5 = new BusVO(" 첨단30"," 국립광주과학관 ~ 운암산코오롱하늘채");
            BusVO vo6 = new BusVO(" 금호36"," 장등동 ~ 서광주역");
            BusVO vo7 = new BusVO(" 매월26"," 매월동 ~ 용전");
            BusVO vo8 = new BusVO(" 운림51"," 첨단 ~ 무등산국립공원(증심사)");
            BusVO vo9 = new BusVO(" 지원25"," 월남동 ~ 서광주역");
            BusVO vo10 = new BusVO(" 일곡38"," 살레시오고 ~ 송산유원지");
            list.add(vo1);
            list.add(vo2);
            list.add(vo3);
            list.add(vo4);
            list.add(vo5);
            list.add(vo6);
            list.add(vo7);
            list.add(vo8);
            list.add(vo9);
            list.add(vo10);
        }
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.route_rcv_item, parent , false );
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.route_stn.setText(list.get(position).getStation());
        holder.route_rt.setText(list.get(position).getRoute());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView route_stn, route_rt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            route_stn = itemView.findViewById(R.id.route_stn);
            route_rt = itemView.findViewById(R.id.route_rt);
        }
    }
}
