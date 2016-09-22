package com.werb.gankwithzhihu.api;

import com.werb.gankwithzhihu.MyApp;
import com.werb.gankwithzhihu.util.StateUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Werb on 2016/8/18.
 * Werb is Wanbo.
 * Contact Me : werbhelius@gmail.com
 * retrofit instance
 */
public class ApiFactory {

    static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/api/4/";
    static final String GANK_BASE_URL = "http://gank.io/api/";
    static final String DAILY_BASE_URL = "http://app3.qdaily.com/app3/";
    static volatile ApiFactory instance;
    ZhihuApi ZhihuApiService;
    GankApi GankApiService;
    DailyApi DailyApiService;
    
    
    
    //okhttpClient cache
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();

        // offline mode
        if (!StateUtils.isNetworkAvailable(MyApp.mContext)) {
            request = request.newBuilder()
                     .cacheControl(cacheControl)
                    //.cacheControl(CacheControl.FORCE_CACHE)
                    .build();

        }

        //设置response
        Response originalResponse = chain.proceed(request);
        if (StateUtils.isNetworkAvailable(MyApp.mContext)) {
            int maxAge = 0; // read from cache 0 sec
            return originalResponse.newBuilder()
                    .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };

    
    ApiFactory() {
        //cache url
        File httpCacheDirectory = new File(MyApp.mContext.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(cache).build();

        Retrofit retrofit_zhihu = new Retrofit.Builder().baseUrl(ZHIHU_BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        Retrofit retrofit_gank = new Retrofit.Builder().baseUrl(GANK_BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory
                (RxJavaCallAdapterFactory.create()).build();

        Retrofit retrofit_daily = new Retrofit.Builder().baseUrl(DAILY_BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory
                (RxJavaCallAdapterFactory.create()).build();

        ZhihuApiService = retrofit_zhihu.create(ZhihuApi.class);
        GankApiService = retrofit_gank.create(GankApi.class);
        DailyApiService = retrofit_daily.create(DailyApi.class);
    }

    public static ZhihuApi getZhihuApiService() {
        return getInstance().ZhihuApiService;
    }

    public static GankApi getGankApiService() {
        return getInstance().GankApiService;
    }

    public static DailyApi getDailyApiService() {
        return getInstance().DailyApiService;
    }

    public static final ApiFactory getInstance() {
        if (instance == null) {
            synchronized (ApiFactory.class) {
                if (instance == null) {
                    instance = new ApiFactory();
                }
            }
        }
        return instance;
    }
}
