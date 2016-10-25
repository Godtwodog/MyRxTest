package com.jack.myrxtest.http;

import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.bean.NewsBean;
import com.jack.myrxtest.config.UrlConfig;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by JackChueng on 2016/10/21.
 */
public class HttpUtils {
    private static volatile HttpUtils httpUtils;
    private Retrofit retrofit_main;
    private IApprove iApprove_main;


    public static HttpUtils getInstace() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    private HttpUtils() {
        retrofit_main = new Retrofit.Builder().baseUrl(UrlConfig.BASE_URL_NEWS).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        iApprove_main = retrofit_main.create(IApprove.class);
    }

//    //Retrofit
//    public void getMain(Map<String, String> parms, Callback<DouyuBean> callback) {
//        Call<DouyuBean> call = iApprove_main.getDouyuData(parms);
//        call.enqueue(callback);
//    }

    //RxJava
    public Observable<List<NewsBean>> getMain_rx(String path) {
        return iApprove_main.getNewsObservable(path);

    }

}
