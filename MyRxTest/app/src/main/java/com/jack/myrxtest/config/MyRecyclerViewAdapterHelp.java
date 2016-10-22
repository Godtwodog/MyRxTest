package com.jack.myrxtest.config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by JackCheung on 2016/9/25 0025.
 */
public abstract class MyRecyclerViewAdapterHelp<T>  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext = null;
    public List<T> list = null;
    public LayoutInflater mInflater = null;
    private RecyclerView recyclerView;
    private boolean isScrolling;//是否在滚动
    private OnItemClickListener listener;//点击事件监听器
    private OnItemLongClickListener longClickListener;//长按监听器

    public MyRecyclerViewAdapterHelp(Context mContext, List<T> list) {
        this.mContext = mContext;
        this.list = list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 定义点击事件接口回调
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    /**
     * 给长按点击事件增加借口回调
     */
    public interface OnItemLongClickListener {
        boolean onItemLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =mInflater.inflate(getLayoutId(),parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v!=null&&recyclerView!=null){
                    int position=recyclerView.getChildAdapterPosition(v);
                    listener.onItemClick(position);}
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (v!=null&&recyclerView!=null){
                    int position=recyclerView.getChildAdapterPosition(v);
                    longClickListener.onItemLongClick(position);
                    return true;
                }
                return false;
            }
        });
        return onCreateViewHolder(parent, viewType);
    }
    public abstract int getLayoutId();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder(holder, position);
    }

    public abstract RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position);

    /**
     * @param viewHolder  ViewHolder
     * @param position    位置
     * @param isScrolling 是否在滑动
     */
    public abstract void convert(RecyclerView.ViewHolder viewHolder, int position, boolean isScrolling);

    @Override
    public int getItemCount() {
        return list.size();
    }



    /**
     * 适配器中添加单条数据，刷新UI
     *
     * @param position 要添加的数据所在适配器中的位置
     * @param data     要添加的数据
     */
    public void addItem(int position, T data) {
        list.add(position, data);
        notifyItemInserted(position);
    }



    /**
     * 适配器中删除单条数据，刷新UI
     *
     * @param position 要删除的数据所在适配器中的位置
     */
    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 适配器中批量删除多条数据，刷新UI
     *
     * @param _list         要删除的数据集合
     * @param positionStart 删除的数据在适配器中的起始位置
     */
    public void removeItems(List<T> _list, int positionStart) {
        list.removeAll(_list);
        int itemCount = list.size();
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    /**
     * 修改适配器中单条数据，刷新UI
     *
     * @param position 更新的数据所在适配器中的位置
     * @param data     更新后的数据集合
     */
    public void updateItem(int position, T data) {
        list.remove(position);
        list.add(position, data);
        notifyItemChanged(position);
    }
}