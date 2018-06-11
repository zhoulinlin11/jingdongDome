package com.example.zll.jingdongdome.util;

import com.example.zll.jingdongdome.bean.CatagoryBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/6/8.
 */

public class CatagoryApi {
    //懒汉单例
    private static CatagoryApi catagoryApi;
    private CatagoryApiService catagoryApiService;

    private CatagoryApi(CatagoryApiService catagoryApiService) {
        this.catagoryApiService = catagoryApiService;
    }
    public static CatagoryApi getCatagoryApi(CatagoryApiService catagoryApiService){
        if (catagoryApi==null){
            catagoryApi=new CatagoryApi(catagoryApiService);
        }
        return catagoryApi;
    }
    public Observable<CatagoryBean> getCatagoryService(){
        return catagoryApiService.getCatagoryService();
    }
}
