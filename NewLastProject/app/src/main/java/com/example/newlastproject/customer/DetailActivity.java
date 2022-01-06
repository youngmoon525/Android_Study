package com.example.newlastproject.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.newlastproject.R;

public class DetailActivity extends Activity implements View.OnClickListener {
    EditText edt_id , edt_name , edt_phone;
    RadioButton rdobtn_m , rdobtn_w;
    Button btn_edit , btn_del , btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent(); //Adapter에서 보내준 Intent를 받아옴.( vo가 들어있음)
        CustomerVO vo = (CustomerVO) intent.getSerializableExtra("vo");

        edt_id = findViewById(R.id.dtl_edtid);
        edt_id.setEnabled(false);//사용할수없게 바꿈. 보여주기만함.
        edt_name = findViewById(R.id.dtl_edtnmae);
        edt_phone = findViewById(R.id.dtl_edtphone);

        rdobtn_m = findViewById(R.id.dtl_rdobtn1);
        rdobtn_w = findViewById(R.id.dtl_rdobtn2);

//        rdobtn_m.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rdobtn_w.setChecked(false);
//            }
//        });
//        rdobtn_w.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rdobtn_m.setChecked(false);
//            }
//        });
        rdobtn_m.setOnClickListener(this);
        rdobtn_w.setOnClickListener(this);

        btn_edit = findViewById(R.id.dtl_btnedit);
        btn_del = findViewById(R.id.dtl_btndel);
        btn_back = findViewById(R.id.dtl_btnback);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerDAO dao = new CustomerDAO();
                vo.setPhone(edt_phone.getText()+"");
                vo.setName(edt_name.getText()+"");
                vo.setPhone(edt_phone.getText()+"");
                if(rdobtn_m.isChecked()) vo.setGender("남");
                if(rdobtn_w.isChecked()) vo.setGender("여");
                dao.edit(vo);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DB쪽(Spring) id를 보내서 해당하는 아이디를 삭제한다.
                CustomerDAO dao = new CustomerDAO();
                dao.delete( vo.getId() + "" );
            }
        });

        initWidget(vo);


    }
    public void initWidget(CustomerVO vo){
        edt_id.setText(vo.getId()+"");
        edt_name.setText(vo.getName()+"");
        edt_phone.setText(vo.getPhone()+"");

        if(vo.getGender() != null && vo.getGender().equals("남") ){
            rdobtn_m.setChecked(true);
        }
        else if(vo.getGender() != null && vo.getGender().equals("남") ){
            rdobtn_w.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        rdobtn_m.setChecked(false);
        rdobtn_w.setChecked(false);
        if(v.getId() == R.id.dtl_rdobtn1) rdobtn_m.setChecked(true);
        if(v.getId() == R.id.dtl_rdobtn2) rdobtn_w.setChecked(true);
    }
}