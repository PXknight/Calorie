package com.zucc.pjx1337.calorie.Setting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zucc.pjx1337.calorie.R;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    @BindView(R.id.setting)TextView setting;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

}
