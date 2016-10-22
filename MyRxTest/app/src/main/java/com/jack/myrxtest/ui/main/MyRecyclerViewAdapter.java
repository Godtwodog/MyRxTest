package com.jack.myrxtest.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jack.myrxtest.R;
import com.jack.myrxtest.config.MyRecyclerViewAdapterHelp;

import java.util.List;

/**
 * Created by JackChueng on 2016/10/22.
 */

public class MyRecyclerViewAdapter  extends MyRecyclerViewAdapterHelp {
    public MyRecyclerViewAdapter(Context mContext, List list) {
        super(mContext, list);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_recyclerview_main;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void convert(RecyclerView.ViewHolder viewHolder, int position, boolean isScrolling) {

    }
}
