package com.zucc.pjx1337.calorie.Share;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zucc.pjx1337.calorie.Adapter.ShareAdapter;
import com.zucc.pjx1337.calorie.BmobBean.Share;
import com.zucc.pjx1337.calorie.LoginActivity;
import com.zucc.pjx1337.calorie.MainActivity;
import com.zucc.pjx1337.calorie.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.share_recycler_view)RecyclerView recyclerView;
    @BindView(R.id.share_fab)FloatingActionButton fab;
    private List<Share> shareList = new ArrayList<>();
    private ShareAdapter adapter;

    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share, container, false);
          // Inflate the layout for this fragment
        //返回一个Unbinder值（进行解绑）
        unbinder = ButterKnife.bind(this, view);
        initShare();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShareAdapter(shareList);
        recyclerView.setAdapter(adapter);


        return view;

    }


    @OnClick(R.id.share_fab)void onFabClick(){
        Intent intent = new Intent(getActivity(), AddShareActivity.class);
        startActivity(intent);

    }

    private void initShare() {
        shareList.clear();

    }

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
