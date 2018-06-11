package com.example.zll.jingdongdome.util;

import com.example.zll.jingdongdome.bean.ProductCatagoryBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/6/9.
 */

public class ProductCatagoryApi {
    private static ProductCatagoryApi productCatagoryApi;
    private ProductCatagoryApiService productCatagoryApiService;

    public ProductCatagoryApi(ProductCatagoryApiService productCatagoryApiService) {
        this.productCatagoryApiService = productCatagoryApiService;
    }
    public static ProductCatagoryApi getProductCatagory(ProductCatagoryApiService productCatagoryApiService){
        if (productCatagoryApi==null){
            productCatagoryApi=new ProductCatagoryApi(productCatagoryApiService);
        }
        return productCatagoryApi;
    }
    public Observable<ProductCatagoryBean> getProductCatagoryApiService(){
        return productCatagoryApiService.getProductCatagoryApiService();
    }
}
