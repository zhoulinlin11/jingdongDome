package com.example.zll.jingdongdome.util;


import com.example.zll.jingdongdome.bean.CatagoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zll on 2018/6/8.
 */

public interface CatagoryApiService {
    @GET("product/getCatagory")
    Observable<CatagoryBean> getCatagoryService();
}
