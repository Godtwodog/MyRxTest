package com.jack.myrxtest.ui.main;

import android.os.Handler;
import android.os.Looper;

import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by JackChueng on 2016/10/21.
 */
public class MainPresenter implements MainConstruct.Presenter {
    private MainConstruct.Model model;
    private MainConstruct.View view;

    public MainPresenter(MainConstruct.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void getView(Map<String, String> params) {
        model.getView(params, new Callback<DouyuBean>() {
            @Override
            public void onResponse(Call<DouyuBean> call, Response<DouyuBean> response) {
                DouyuBean douyuBean = response.body();
                final List<DataBean> totalList = douyuBean.getData();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.getSuccess(totalList);
                    }
                });
            }

            @Override
            public void onFailure(Call<DouyuBean> call, Throwable t) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.getFailed("服务器异常");
                    }
                });
            }
        });
    }
}
