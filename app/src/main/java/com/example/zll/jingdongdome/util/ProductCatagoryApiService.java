package com.example.zll.jingdongdome.util;

import com.example.zll.jingdongdome.bean.ProductCatagoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zll on 2018/6/9.
 */

public interface ProductCatagoryApiService {
    @GET("product/getProductCatagory")
    Observable<ProductCatagoryBean> getProductCatagoryApiService();
}
