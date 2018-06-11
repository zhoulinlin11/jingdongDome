package com.example.zll.jingdongdome.module;

import com.example.zll.jingdongdome.util.AdApiService;
import com.example.zll.jingdongdome.util.Api;
import com.example.zll.jingdongdome.util.CatagoryApi;
import com.example.zll.jingdongdome.util.CatagoryApiService;
import com.example.zll.jingdongdome.util.GetAdApi;
import com.example.zll.jingdongdome.util.ProductCatagoryApi;
import com.example.zll.jingdongdome.util.ProductCatagoryApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zll on 2018/6/7.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder proviteOkHttpClient(){
        return new OkHttpClient.Builder()
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);

    }
    @Provides
    GetAdApi proviteAdApi(OkHttpClient.Builder builder){
        AdApiService adApiService = new Retrofit.Builder()
                .baseUrl(Api.Adurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build()
                .create(AdApiService.class);
        return GetAdApi.getAdApi(adApiService);
    }
    @Provides
    CatagoryApi proviteCatagroryApi(OkHttpClient.Builder builder){
        CatagoryApiService catagoryApiService = new Retrofit.Builder()
                .baseUrl(Api.Adurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build()
                .create(CatagoryApiService.class);
        return CatagoryApi.getCatagoryApi(catagoryApiService);
    }
    @Provides
    ProductCatagoryApi proviteProductCatagoryApi(OkHttpClient.Builder builder){
        ProductCatagoryApiService productCatagoryApiService = new Retrofit.Builder()
                .baseUrl(Api.Adurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build()
                .create(ProductCatagoryApiService.class);
        return ProductCatagoryApi.getProductCatagory(productCatagoryApiService);
    }
}
