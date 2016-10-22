package com.jack.myrxtest.ui.main;

import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by JackCheung on 2016/10/21.
 */
public class MainModel implements MainConstruct.Model{

    @Override
    public void getView(Map<String, String> params, Callback<DouyuBean> callback) {
        HttpUtils.getInstace().getMain(params,callback);
    }
}
