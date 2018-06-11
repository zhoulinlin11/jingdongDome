package com.example.zll.jingdongdome.ui.catagory;

import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.HomePageBean;
import com.example.zll.jingdongdome.bean.ProductCatagoryBean;
import com.example.zll.jingdongdome.ui.base.BaseContract;

/**
 * Created by zll on 2018/6/8.
 */

public interface CatagoryContarct {
    interface View extends BaseContract.BaseView{
        void getCatagoryView(CatagoryBean catagoryBean);
        void getProductCatagoryView(ProductCatagoryBean productCatagoryBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getCatagoryPresenter();
        void getProductCatagoryPresenter();

    }
}
