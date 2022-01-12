package com.example.chaminhwan_kakaostory.fgm.common;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.chaminhwan_kakaostory.MainActivity;
import com.example.chaminhwan_kakaostory.R;

public class ChangeFragment extends AppCompatActivity {




    public void changeFragment(Fragment fragment, int contId) {
        getSupportFragmentManager().beginTransaction().replace(contId, fragment).commit();
    }

}
