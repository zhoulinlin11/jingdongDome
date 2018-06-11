package com.example.zll.jingdongdome.ui.catagory;

import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.ProductCatagoryBean;
import com.example.zll.jingdongdome.ui.base.BasePresenter;
import com.example.zll.jingdongdome.util.CatagoryApi;
import com.example.zll.jingdongdome.util.ProductCatagoryApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/6/8.
 */

public class CatagoryPresenter extends BasePresenter<CatagoryContarct.View> implements CatagoryContarct.Presenter {
    CatagoryApi catagoryApi;
    ProductCatagoryApi productCatagoryApi;
    @Inject
    public CatagoryPresenter(CatagoryApi catagoryApi,ProductCatagoryApi productCatagoryApi) {
        this.catagoryApi = catagoryApi;
        this.productCatagoryApi=productCatagoryApi;
    }

    @Override
    public void getCatagoryPresenter() {
     catagoryApi.getCatagoryService()
             .observeOn(AndroidSchedulers.mainThread())
             .subscribeOn(Schedulers.io())
             .map(new Function<CatagoryBean, CatagoryBean>() {
                 @Override
                 public CatagoryBean apply(CatagoryBean catagoryBean) throws Exception {
                     return catagoryBean;
                 }
             }).subscribe(new Consumer<CatagoryBean>() {
         @Override
         public void accept(CatagoryBean catagoryBean) throws Exception {
             if (mView!=null){
                 mView.getCatagoryView(catagoryBean);
             }
         }
     });
    }

    @Override
    public void getProductCatagoryPresenter() {
        productCatagoryApi.getProductCatagoryApiService()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductCatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean productCatagoryBean) {
                        mView.getProductCatagoryView(productCatagoryBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
