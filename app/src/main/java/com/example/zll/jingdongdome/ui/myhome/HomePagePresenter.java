package com.example.zll.jingdongdome.ui.myhome;

import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.HomePageBean;
import com.example.zll.jingdongdome.ui.base.BasePresenter;
import com.example.zll.jingdongdome.util.CatagoryApi;
import com.example.zll.jingdongdome.util.GetAdApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.IntFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/6/7.
 */

public class HomePagePresenter extends BasePresenter<HomePageContract.View> implements HomePageContract.Presenter {
    CatagoryApi catagoryApi;
    GetAdApi getAdApi;
   @Inject
    public HomePagePresenter(GetAdApi getAdApi,CatagoryApi catagoryApi) {
        this.getAdApi = getAdApi;
        this.catagoryApi = catagoryApi;
    }

    @Override
    public void getAd() {
      getAdApi.getService()
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeOn(Schedulers.io())
              .map(new Function<HomePageBean, HomePageBean>() {
                  @Override
                  public HomePageBean apply(HomePageBean homePageBean) throws Exception {
                      return homePageBean;
                  }
              })
              .subscribe(new Consumer<HomePageBean>() {
                  @Override
                  public void accept(HomePageBean homePageBean) throws Exception {
                      if (mView!=null){
                          mView.getAdView(homePageBean);
                      }
                  }
              });
    }
    @Override
    public void getCatagoryPresenter1() {
        catagoryApi.getCatagoryService()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                     mView.getCatagoryView1(catagoryBean);
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
