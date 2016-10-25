package com.jack.myrxtest.ui.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jack.myrxtest.R;
import com.jack.myrxtest.bean.NewsBean;
import com.jack.myrxtest.http.HttpUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 总体思路，RxJava是由观察者和被观察者实现，首先创建被观察者，发出事件传递，通过filter方法经行过滤。
 * 通过subscribe方法产生订阅事件，同时创建被观察者，接受事件，作为整个事件传递的终点，结束整个事件传递
 */
public class MainActivity extends AppCompatActivity implements MainConstruct.View{
    private Context mContext = MainActivity.this;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<NewsBean> totalList = new ArrayList<>();
    private MainConstruct.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new MainPresenter(this);
        presenter.getView("newslist.aspx");
        initView();


    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    public void getSuccess(List<NewsBean> totalList) {
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(mContext, totalList);
        myRecyclerViewAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    @Override
    public void getFailed(String error) {
            Toast.makeText(mContext,"mistake",Toast.LENGTH_LONG).show();
    }


}
