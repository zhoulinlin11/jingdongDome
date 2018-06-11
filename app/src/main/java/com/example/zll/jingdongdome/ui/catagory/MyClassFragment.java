package com.example.zll.jingdongdome.ui.catagory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongdome.R;
import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.ProductCatagoryBean;
import com.example.zll.jingdongdome.module.HttpModule;
import com.example.zll.jingdongdome.moduleconprosent.DaggerHttpModuleconprosent;
import com.example.zll.jingdongdome.ui.base.BaseFragment;
import com.example.zll.jingdongdome.ui.catagory.adapter.CatagoryAdapter;

import java.util.List;

/**
 * Created by zll on 2018/6/7.
 */

public class MyClassFragment extends BaseFragment<CatagoryPresenter> implements CatagoryContarct.View {

    private RecyclerView left_rv;
    private RecyclerView right_rv;

    @Override
    public int getContentLoayout() {
        return R.layout.myclass1;
    }

    @Override
    public void inject() {
        DaggerHttpModuleconprosent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        mPresenter.getCatagoryPresenter();
        left_rv = view.findViewById(R.id.left_rv);
        right_rv = view.findViewById(R.id.right_rv);
        left_rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void getCatagoryView(CatagoryBean catagoryBean) {
        List<CatagoryBean.DataBean> data = catagoryBean.getData();
        CatagoryAdapter adapter=new CatagoryAdapter(data,getContext());
        left_rv.setAdapter(adapter);


    }

    @Override
    public void getProductCatagoryView(ProductCatagoryBean productCatagoryBean) {

    }
}
