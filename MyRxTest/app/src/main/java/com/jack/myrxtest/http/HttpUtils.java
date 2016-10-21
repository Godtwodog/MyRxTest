package com.jack.myrxtest.http;

import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.config.UrlConfig;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by JackChueng on 2016/10/21.
 */
public class HttpUtils {
    private  static volatile HttpUtils httpUtils;
    private Retrofit retrofit_main;
    private IApprove iApprove_main;



    public static HttpUtils getInstace(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    private HttpUtils(){
        retrofit_main=new Retrofit.Builder().baseUrl(UrlConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        iApprove_main=retrofit_main.create(IApprove.class);
    }


    public Observable<DouyuBean> getDouyu(Map<String, String> params) {
        return iApprove_main.getDouyuData(params);
    }


}
