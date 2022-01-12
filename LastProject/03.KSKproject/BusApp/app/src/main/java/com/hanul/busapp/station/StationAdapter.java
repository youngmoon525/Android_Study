package com.hanul.busapp.station;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hanul.busapp.R;
import com.hanul.busapp.bus.BusVO;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<BusVO> list;


    public StationAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i < 20; i ++){
            BusVO vo1 = new BusVO("양산초교입구","| 양산호수공원방향(4058)");
            BusVO vo2 = new BusVO("양산호수공원","| 롯데칠성방향(4078)");
            BusVO vo3 = new BusVO("롯데칠성","| 코카콜라방향(4030)");
            BusVO vo4 = new BusVO("해태칠성","| 박물관입구방향(4452)");
            BusVO vo5 = new BusVO("박물관입구","| 체육고/폴리텍5대학방향(4206)");
            BusVO vo6 = new BusVO("체육고.폴리텍대학","| 문화예술회관방향(4461)");
            BusVO vo7 = new BusVO("문화예술회관","| 운암시장방향(4441)");
            BusVO vo8 = new BusVO("광천치안센터","| 광천터미널방향(2003)");
            BusVO vo9 = new BusVO("신세계백화점","| 화정중흥파크방향(2276)");
            BusVO vo10 = new BusVO("화정중흥파크","| 서구보건소방향(2283)");
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
        View itemview = inflater.inflate(R.layout.station_rcv_item, parent , false );
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.stations_stn.setText(list.get(position).getStation());
        holder.station_rt.setText(list.get(position).getRoute());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView stations_stn, station_rt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stations_stn = itemView.findViewById(R.id.stations_stn);
            station_rt = itemView.findViewById(R.id.station_rt);
        }
    }
}
