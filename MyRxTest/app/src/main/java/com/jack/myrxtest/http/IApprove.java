package com.jack.myrxtest.http;

import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.config.UrlConfig;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;



/**
 * Created by JackChueng on 2016/10/21.
 */
public interface IApprove {
   @GET(UrlConfig.BASE_URL)
   Call<DouyuBean> getDouyuData(@QueryMap() Map<String,String> params);

}
