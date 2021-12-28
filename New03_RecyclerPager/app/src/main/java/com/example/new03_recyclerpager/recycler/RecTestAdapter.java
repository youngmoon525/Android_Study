package com.example.new03_recyclerpager.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new03_recyclerpager.R;

//2. extends <- RecyclerView.adpater 상속받기.
public class RecTestAdapter extends RecyclerView.Adapter<RecTestAdapter.ViewHolder>{


    //3. 필요한 정보들을 Activity나 Fragment로 붙어 받아와서 생성할수있게함.
    // Layout을 붙이기위한 ( Inflater )
    // Inflater , Context를 가지고있는 화면단에서 받아올수가있음 ( 현재 클래스 )
    Context context;
    LayoutInflater inflater;
    public RecTestAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //4.※ 리사클러뷰 한칸마다 보여줄 xml을 연결시켜서 붙여주는 부분 ( ViewHolder라는 ViewGroup )
    // == ImageView , TextView... 묶어놓는 단계.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycleritem2 , parent , false);
        return new ViewHolder(itemView);
    }
    //5.↓ 위에 단계가 끝나고나서 ViewHolder라는 그룹을 만든후 Bind라는 작업 ( List에 있는 내용<=> ItemView)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }
    //6.끝 -> Activity에가서 4번작업시작 ( Adapter 완료 후 작업 )
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
