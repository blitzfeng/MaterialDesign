package com.blitzfeng.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blitzfeng.materialdesign.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/29 0029.
 */
public class MainAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private List<String> list = new ArrayList<>();
    public MainAdapter(Context context,List<String> list) {
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recyler_item_main,parent,false);
        ViewHolder holder = new ViewHolder(v);
        ViewUtils.inject(holder,v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        LogUtils.i(list.get(position)+"---");
        viewHolder.contentTv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        @ViewInject(R.id.tv_content)
        private TextView contentTv;
        public ViewHolder(View itemView) {
            super(itemView);
       //     contentTv = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
