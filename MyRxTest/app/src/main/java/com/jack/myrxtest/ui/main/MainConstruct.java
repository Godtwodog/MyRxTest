package com.jack.myrxtest.ui.main;

import com.jack.myrxtest.base.IBaseModle;
import com.jack.myrxtest.base.IBasePresenter;
import com.jack.myrxtest.base.IBaseView;
import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by JackCheung on 2016/10/21.
 */
public class MainConstruct {
    public interface Model extends IBaseModle{
        public void getView(Map<String,String> params, Callback<DouyuBean> callback);
    }
    public interface View extends IBaseView{
        public void  getSuccess(List<DataBean> totalList);
        public void getFailed(String error);
    }
    public interface Presenter extends IBasePresenter{
        public void getView(Map<String,String> params);
    }
}
