package com.jack.myrxtest.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jack.myrxtest.R;
import com.jack.myrxtest.bean.NewsBean;
import com.jack.myrxtest.config.MyRecyclerViewAdapterHelp;

import java.util.List;

/**
 * Created by JackChueng on 2016/10/22.
 */

public class MyRecyclerViewAdapter  extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<NewsBean> list;

    public MyRecyclerViewAdapter(Context context, List<NewsBean> list){
        this.context=context;
        this.list=list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_main,null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getIcon()).into(holder.imageView);
        holder.textView.setText(list.get(position).getDesc()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView_item_main);
            textView= (TextView) itemView.findViewById(R.id.textView_item_main);
        }
    }

    //刷新数据
    public void reloadRecyclerView(List<NewsBean> _list, boolean isClear) {
        if (isClear) {
            list.clear();
        }
        list.addAll(_list);
        notifyDataSetChanged();
    }
}
