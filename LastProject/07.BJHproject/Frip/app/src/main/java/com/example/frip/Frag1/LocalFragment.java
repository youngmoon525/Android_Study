package com.example.frip.Frag1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.frip.Login.LoginActivity;
import com.example.frip.Login.LoginActivity2;
import com.example.frip.MainActivity;
import com.example.frip.R;


public class LocalFragment extends Fragment {

    MainActivity mainActivity = new MainActivity();
    ImageView btn_local_back;
    Context context;

    public LocalFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local, container, false);

        btn_local_back = view.findViewById(R.id.btn_local_back);

        btn_local_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container , new Fragment1(context)).commit();





            }
        });









        return view;
    }
}