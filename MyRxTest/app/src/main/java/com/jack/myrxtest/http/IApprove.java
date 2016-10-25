package com.jack.myrxtest.http;

import com.jack.myrxtest.bean.DouyuBean;
import com.jack.myrxtest.bean.NewsBean;
import com.jack.myrxtest.config.UrlConfig;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by JackChueng on 2016/10/21.
 *
 */
public interface IApprove {
   //使用retrofit实现网络请求
   @GET(UrlConfig.BASE_URL)
   Call<DouyuBean> getDouyuData(@QueryMap() Map<String,String> params);


   //使用RxJava加载数据，简便起见不再进行网址配置
   @GET("{type}?tid=0&minId=495127&maxId=0&ver=2.2&temp=1470901806343")
   Observable<List<NewsBean>> getNewsObservable(@Path("type") String type);

   /*
   使用RxJava结合retrofit使用
     使用 RxJava的形式 将retrofit的请求封装到Observable对象中
    */
//   public void loadData02(){
//      //获取被观察者对象
//      Observable observable=serviceInterface.getNewsObservable("newslist.aspx");
//      observable.
//              subscribeOn(Schedulers.io()).
//              observeOn(AndroidSchedulers.mainThread())
//              .subscribe(new Observer<List<News>>() {
//                 @Override
//                 public void onCompleted() {}
//                 @Override
//                 public void onError(Throwable e) {
//                    e.printStackTrace();
//                 }
//                 @Override
//                 public void onNext(List<News> list) {
//                    adapter.reloadRecyclerView(list,true);
//                 }
//              });
//   }
}
