package com.example.zll.jingdongdome.ui.base;

/**
 * Created by zll on 2018/6/7.
 */
//view与p层的共参数
public interface BaseContract {
    //泛型上线
    interface BasePresenter<T extends BaseView>{
        //绑定解绑
        void attachView(T view);
        void detachView();
    }
    interface BaseView{

    }

}
