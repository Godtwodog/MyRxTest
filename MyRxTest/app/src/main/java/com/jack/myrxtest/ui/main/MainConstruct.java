package com.jack.myrxtest.ui.main;

import com.jack.myrxtest.base.IBaseModle;
import com.jack.myrxtest.base.IBasePresenter;
import com.jack.myrxtest.base.IBaseView;
import com.jack.myrxtest.bean.DataBean;
import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.bean.NewsBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;
import rx.Observable;

/**
 * Created by JackCheung on 2016/10/21.
 */
public class MainConstruct {

    public interface Model extends IBaseModle{
        public void getView(String params);
    }
    public interface View extends IBaseView{
        public void  getSuccess(List<NewsBean> totalList);
        public void getFailed(String error);
    }

    public interface Presenter extends IBasePresenter{
        public void getView(String params);
    }
}
