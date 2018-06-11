package com.example.zll.jingdongdome.util;

import com.example.zll.jingdongdome.bean.HomePageBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zll on 2018/6/7.
 */

public interface AdApiService {
    @GET("ad/getAd")
    Observable<HomePageBean> getadService();
}
