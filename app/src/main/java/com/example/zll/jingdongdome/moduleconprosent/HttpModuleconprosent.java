package com.example.zll.jingdongdome.moduleconprosent;

import com.example.zll.jingdongdome.ui.catagory.MyClassFragment;
import com.example.zll.jingdongdome.ui.myhome.HomePageFragment;
import com.example.zll.jingdongdome.module.HttpModule;

import dagger.Component;

/**
 * Created by zll on 2018/6/7.
 */
@Component(modules = HttpModule.class)
public interface HttpModuleconprosent {
    void inject(HomePageFragment homePageFragment);
    void inject(MyClassFragment myClassFragment);
}
