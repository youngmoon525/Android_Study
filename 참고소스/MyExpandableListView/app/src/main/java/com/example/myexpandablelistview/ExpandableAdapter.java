package com.example.myexpandablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableAdapter extends BaseExpandableListAdapter {


    LayoutInflater inflater;
    ArrayList<ExpdDTO> list;

    public ExpandableAdapter(LayoutInflater inflater, ArrayList<ExpdDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }



    // 부모 사이즈 = 현재 부모사이즈는 ArrayList의 사이즈 그대로를 주면됩니다.
    @Override
    public int getGroupCount() {
        return list.size();
    }
    //자식 사이즈 = 등록 된 답변이 있다면 부모↑ ListView에 자식 리스트뷰를 몇개 붙일건지
    //사이즈를 지정하는 부분.
    @Override
    public int getChildrenCount(int i) {
        if(list.get(i).getAnswer() != null){
        return 1;

        }
        return  0;

    }

    // 그룹 오브젝트 ( 아이템을 선택했을때 return 받을 DTO)
    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }
    // 자식 오브젝트 ( 자식 아이템을 선택했을때 return 받을 데이터 현재는 String값을
    // return 받게 해둠. )
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getAnswer();
    }


    //포지션 부분 그냥 고정적으로 사용하면됨.
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // groupPosition은 부모 인덱스 , childPosition은
    //부모에서 자식 인덱스 두개를 응용해서 사용도 가능함.
    // ex) 1번 group에서 3번째 자식을 선택한 경우 이벤트.. 등등 )
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //true 그냥 놔두시면 됩니다.
    @Override
    public boolean hasStableIds() {
        return true;
    }


    //부모 아이템에 보여줄 xml을 연결하는 코드.
    //RecyclerView( getView 메소드랑 똑같음 )
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.group_item , parent , false);
            viewHolder = new GroupViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (GroupViewHolder) convertView.getTag();
        }
        viewHolder.bind(groupPosition);
        return convertView;
    }



    //자식 아이템에 보여줄 xml을 연결하는 코드.
    //RecyclerView( getView 메소드랑 똑같음 )
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder viewHolder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.child_item , parent , false);
            viewHolder = new ChildViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ChildViewHolder) convertView.getTag();
        }
        viewHolder.bind(groupPosition);
        return convertView;
    }

    // 자식이 선택되었는지 안되었는지를 판단할수있는 메소드
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    //부모 위젯들을 하나의 클래스로 묶어놓을 ViewHolder
    //매번 화면이 전환되거나 스크롤이 위아래로 바뀔때마다 ConvertView에있는
    //위젯을 다시 찾는게아니라 미리 클래스를 지정해놓고 저장해놓고 사용하기 위함.
    public class GroupViewHolder {
        public TextView tv_content , tv_title , tv_date;

        public GroupViewHolder(View itemview) {
            tv_content = itemview.findViewById(R.id.tv_content);
            tv_title = itemview.findViewById(R.id.tv_title);
            tv_date = itemview.findViewById(R.id.tv_date);
        }

        public void bind(int i) {
            tv_content.setText(list.get(i).getContent());
            tv_date.setText(list.get(i).getDate());
            tv_title.setText(list.get(i).getTitle());
        }
    }

    public class ChildViewHolder {
        public TextView tv_answer;

        public ChildViewHolder(View itemview) {
            tv_answer= itemview.findViewById(R.id.tv_answer);
        }
        public void bind(int i) {
            tv_answer.setText(list.get(i).getAnswer());
        }
    }

}
