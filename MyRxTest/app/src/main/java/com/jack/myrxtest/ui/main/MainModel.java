package com.jack.myrxtest.ui.main;

import com.jack.myrxtest.http.HttpUtils;
import rx.Observable;


/**
 * Created by JackCheung on 2016/10/21.
 */
public class MainModel implements MainConstruct.Model{
    protected static Observable observable;
    @Override
    public void getView(String params) {
            HttpUtils.getInstace().getMain_rx(params);

}}
