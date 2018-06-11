package com.example.zll.jingdongdome.ui.myhome;

import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.HomePageBean;
import com.example.zll.jingdongdome.ui.base.BaseContract;

/**
 * Created by zll on 2018/6/7.
 *         void getCatagory(CatagoryBean catagoryBean);
 */

public interface HomePageContract {
    //view接口
    interface View extends BaseContract.BaseView{
        void getAdView(HomePageBean homePageBean);
        void getCatagoryView1(CatagoryBean catagoryBean);
    }
    //p层级口
    interface Presenter extends BaseContract.BasePresenter<View>{
           void getAd();
        void getCatagoryPresenter1();
    }
}
