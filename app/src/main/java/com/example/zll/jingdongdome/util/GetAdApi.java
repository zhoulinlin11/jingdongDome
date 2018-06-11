package com.example.zll.jingdongdome.util;

import com.example.zll.jingdongdome.bean.HomePageBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/6/7.
 */

public class GetAdApi {
    //单例中的懒汉式
    private static GetAdApi getAdApi;
    private  AdApiService adApiService;

    private GetAdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }
    public static GetAdApi getAdApi(AdApiService adApiService){
        if (getAdApi==null){
            getAdApi=new GetAdApi(adApiService);
        }
        return getAdApi;
    }
    public Observable<HomePageBean> getService(){
        return adApiService.getadService();
    }
}
