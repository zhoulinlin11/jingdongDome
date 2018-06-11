package com.example.zll.jingdongdome.ui.myhome;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zll.jingdongdome.R;
import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.bean.HomePageBean;
import com.example.zll.jingdongdome.imageloder.GildImageLoder;
import com.example.zll.jingdongdome.inter.OnIteamClick;
import com.example.zll.jingdongdome.module.HttpModule;
import com.example.zll.jingdongdome.moduleconprosent.DaggerHttpModuleconprosent;
import com.example.zll.jingdongdome.net.WebActivity;
import com.example.zll.jingdongdome.ui.base.BaseFragment;
import com.example.zll.jingdongdome.ui.myhome.adapter.HomePageFenleiAdapter;
import com.example.zll.jingdongdome.ui.myhome.adapter.HomePageMiaosha;
import com.example.zll.jingdongdome.ui.myhome.adapter.HomePagetuijian;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/6/7.
 */

public class HomePageFragment extends BaseFragment<HomePagePresenter> implements HomePageContract.View {

    private Banner mBanner;
    private RecyclerView mFenlei;
    private RecyclerView mMiaosha;
    private RecyclerView mTuijian;
    private MarqueeView marqueeView;

    @Override
    public int getContentLoayout() {
        return R.layout.homepage1;
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
        mBanner = (Banner) view.findViewById(R.id.banner);
        mFenlei = (RecyclerView) view.findViewById(R.id.fenlei);
        mMiaosha = (RecyclerView) view.findViewById(R.id.miaosha);
        mTuijian = (RecyclerView) view.findViewById(R.id.tuijian);

        marqueeView = view.findViewById(R.id.marqueeView);
        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);
        //获取数据
        mPresenter.getAd();
        mPresenter.getCatagoryPresenter1();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.HORIZONTAL, false);
        mFenlei.setLayoutManager(gridLayoutManager);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, LinearLayoutManager.HORIZONTAL, false);
        mMiaosha.setLayoutManager(gridLayoutManager1);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mTuijian.setLayoutManager(gridLayoutManager2);
        //设置图片
        mBanner.setImageLoader(new GildImageLoder());
    }

    @Override
    public void getAdView(HomePageBean homePageBean) {
        List<HomePageBean.DataBean> data = homePageBean.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getIcon());
        }
        //设置图片集合
        mBanner.setImages(list);
        //开启轮播图
        mBanner.start();

        final List<HomePageBean.MiaoshaBean.ListBeanX> list1 = homePageBean.getMiaosha().getList();
        HomePageMiaosha adapter = new HomePageMiaosha(list1, getContext());
        mMiaosha.setAdapter(adapter);
        adapter.setOnIteamClick(new OnIteamClick() {
            @Override
            public void setIteamLinstent(int position) {
                String detailUrl = list1.get(position).getDetailUrl();
                Intent intent=new Intent(getContext(),WebActivity.class);
                intent.putExtra("DetailUrl",detailUrl);
                startActivity(intent);
            }
        });


        final List<HomePageBean.TuijianBean.ListBean> list2 = homePageBean.getTuijian().getList();
        HomePagetuijian adapter1 = new HomePagetuijian(list2, getContext());
        mTuijian.setAdapter(adapter1);
        adapter1.getItemOnclick(new OnIteamClick() {
            @Override
            public void setIteamLinstent(int position) {
                String detailUrl = list2.get(position).getDetailUrl();
                Intent intent=new Intent(getContext(),WebActivity.class);
                intent.putExtra("DetailUrl",detailUrl);
                startActivity(intent);
            }
        });


    }

    @Override
    public void getCatagoryView1(CatagoryBean catagoryBean) {
        final List<CatagoryBean.DataBean> data = catagoryBean.getData();
        HomePageFenleiAdapter adapter2 = new HomePageFenleiAdapter(data, getContext());
        mFenlei.setAdapter(adapter2);
        adapter2.setHomepageIteam(new OnIteamClick() {
            @Override
            public void setIteamLinstent(int position) {
                //吐司
                Toast.makeText(getContext(),data.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}
