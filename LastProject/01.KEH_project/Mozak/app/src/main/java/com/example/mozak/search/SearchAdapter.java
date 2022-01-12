package com.example.mozak.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mozak.R;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {
    private static final String TAG = "tv1 onclick!";
    Context context;    //null ← 디자인 foreGround == frontGround  보이는
                        // ↑ BackGround (Context) == 생성자    보이지않는
    ArrayList<SearchDTO> list;
    LayoutInflater inflater;
    //GridAdapter ← FragmentGrid.Class(java) 생성해보기
    public SearchAdapter(Context context, ArrayList<SearchDTO> list) {
        this.context = context;
        this.list = list;
        //this.inflater = inflater; ←만들어서 넘겨준거 세팅, ↓직접 만들기
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addItem(ArrayList<SearchDTO> list){
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //실제 화면을 띄우는 부분, 커스터마이징이 가장 많이 되는 부분
    //직접 GridView에 보여지는 Layout처리를 해야함. java ↔ xml
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchViewHolder viewHolder;
        if (convertView == null){   //아직 초기 디자인이 없는 상태의 view라면
            convertView = inflater.inflate(R.layout.searchitem, parent, false);
                                        //(layout, parent, 제어권 false)
            viewHolder = new SearchViewHolder();
            viewHolder.imgv1 = convertView.findViewById(R.id.search_imgv);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (SearchViewHolder) convertView.getTag();
        }

        return convertView;
    }
    //ViewHolder ← 위젯들을 하나로 묶은 클래스를 만들고 사용
    public class SearchViewHolder{
        public ImageView imgv1;
    }

}
