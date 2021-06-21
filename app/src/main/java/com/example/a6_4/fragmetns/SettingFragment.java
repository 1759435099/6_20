package com.example.a6_4.fragmetns;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a6_4.FirstActivity;
import com.example.a6_4.R;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class SettingFragment extends Fragment {
    Button tuichu;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_frag_setting, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tuichu = getActivity().findViewById(R.id.tuichu);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FirstActivity.class);
                  startActivity(intent);
            }
        });
    }
}
