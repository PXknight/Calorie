package com.zucc.pjx1337.calorie.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zucc.pjx1337.calorie.BmobBean.Share;
import com.zucc.pjx1337.calorie.R;

import java.util.List;

import butterknife.BindView;

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.ViewHolder>{

    private Context mContext;
    private List<Share> mShareList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image;
        TextView title;
        TextView context;

        public ViewHolder(View view) {
            super(view);
//            绑定xml布局中的控件
            cardView = (CardView) view;
            title = (TextView)view.findViewById(R.id.share_title);
            context = (TextView)view.findViewById(R.id.share_context);

        }
    }

    public ShareAdapter(List<Share> shareList) {
        mShareList = shareList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.share_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        Share share = mShareList.get(position);
        holder.title.setText(share.getTitle());
        holder.context.setText(share.getContent());
    }

    @Override
    public int getItemCount() {
        return mShareList.size();
    }
}
