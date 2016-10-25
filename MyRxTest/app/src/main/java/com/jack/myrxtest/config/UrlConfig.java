package com.jack.myrxtest.config;

/**
 * Created by JackChueng on 2016/10/21.
 *
 http://m.mydrivers.com/app/newslist.aspx?tid=0&minId=495127&maxId=0&ver=2.2&temp=1470901806343
 */
public class UrlConfig {
    //    http://capi.douyucdn.cn/api/v1/getVerticalRoom?limit=20&offset=0&time=1470800460
    public static final String BASE_URL = "http://capi.douyucdn.cn/";
    public static final String BASE_URL_NEWS="http://m.mydrivers.com/app/";
    public static class Path {
        public static final String URL_HOT = "api/v1/getVerticalRoom";
        public static final String URL_NEWS="app/newslist.aspx";
    }

    public static class Params {
        public static final String LIMIT = "limit";
        public static final String OFFSET = "offset";
        public static final String TIME = "time";
    }

    public static class DefaultValue {
        public static final String LIMIT = "20";
        public static final String OFFSET = "0";
        public static final String TIME = "1470800460";
    }
}
