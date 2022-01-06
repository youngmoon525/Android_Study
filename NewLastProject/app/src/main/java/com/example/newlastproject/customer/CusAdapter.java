package com.example.newlastproject.customer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlastproject.LoginActivity;
import com.example.newlastproject.R;

import java.util.ArrayList;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.Viewholder> {
    //xml로 만들어놓은 아이템을 붙이기위한 LayoutInfler <- Context
    Context context;
    ArrayList<CustomerVO> list;
    LayoutInflater inflater;

    public CusAdapter(Context context, ArrayList<CustomerVO> list) {
        this.context = context;
        this.list = list;
        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //화면을 인플레이트 시키는 작업을 하기.
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cus_rcv_item , parent , false);
        //Viewholder viewholder = new Viewholder(itemView);
       // return viewholder;
        return  new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
            holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView tv_no , tv_name , tv_phone ;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgv = itemView.findViewById(R.id.cus_imgv);
            tv_no = itemView.findViewById(R.id.cus_tv_no);
            tv_name = itemView.findViewById(R.id.cus_tv_name);
            tv_phone = itemView.findViewById(R.id.cus_tv_phone);
        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull Viewholder holder, int position){
            //내용 바꾸기 처리
            holder.tv_no.setText( list.get(position).getNo() +"" );
            holder.tv_name.setText( list.get(position).getName() );
            holder.tv_phone.setText( list.get(position).getPhone() );

            holder.tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Detail로 이동 , Detail에서 추가 수정 삭제.
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("vo" , list.get(position));
                   // intent.putExtra("id" , list.get(position).getId());
                    context.startActivity(intent);
                }
            });

        }

    }

}//CusAdapter
