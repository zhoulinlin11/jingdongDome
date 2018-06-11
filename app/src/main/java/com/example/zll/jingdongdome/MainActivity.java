package com.example.zll.jingdongdome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;


import com.example.zll.jingdongdome.ui.find.FindFragment;
import com.example.zll.jingdongdome.ui.myhome.HomePageFragment;
import com.example.zll.jingdongdome.fragment.MineFragment;
import com.example.zll.jingdongdome.ui.catagory.MyClassFragment;
import com.example.zll.jingdongdome.fragment.ShapCarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private RadioGroup mRg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //定义集合
        final List<Fragment> fragments=new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new MyClassFragment());
        fragments.add(new FindFragment());
        fragments.add(new ShapCarFragment());
        fragments.add(new MineFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_homepage:
                        mVp.setCurrentItem(0);
                        break;
                    case R.id.rb_class:
                        mVp.setCurrentItem(1);
                        break;
                    case R.id.rb_find:
                        mVp.setCurrentItem(2);
                        break;
                    case R.id.shopcar:
                        mVp.setCurrentItem(3);
                        break;
                    case R.id.mine:
                        mVp.setCurrentItem(4);
                        break;
                }
            }
        });
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              switch (position){
                  case 0:
                      mRg.check(R.id.rb_homepage);
                      break;
                  case 1:
                      mRg.check(R.id.rb_class);
                      break;
                  case 2:
                      mRg.check(R.id.rb_find);
                      break;
                  case 3:
                      mRg.check(R.id.shopcar);
                      break;
                  case 4:
                      mRg.check(R.id.mine);
                      break;
              }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mRg = (RadioGroup) findViewById(R.id.rg);
    }
}
