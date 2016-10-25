package com.jack.myrxtest.ui.main;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.bean.NewsBean;
import com.jack.myrxtest.http.HttpUtils;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JackChueng on 2016/10/21.
 */
public class MainPresenter implements MainConstruct.Presenter {
    private MainConstruct.Model model;
    private MainConstruct.View view;
        private Observable observable;
    public MainPresenter(MainConstruct.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void getView(String params) {

        Observable observable=
                HttpUtils.getInstace().getMain_rx("newslist.aspx");
        observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<List<NewsBean>>() {
                     @Override
                     public void onCompleted() {

                     }

                     @Override
                     public void onError(Throwable e) {
                         view.getFailed("服务器异常");
                     }

                     @Override
                     public void onNext(List<NewsBean> newsBeen) {
                         view.getSuccess(newsBeen);
                     }


                 });


    }



    }

