package com.example.tianshuai.mainframedemo.fragment;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.tianshuai.mainframedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianshuai on 2017/4/27.
 */

public class MainFragment extends Fragment {
    private String context;
    private TextView mTextView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPagerAdapter myPagerAdapter;
    View view;

    public  MainFragment(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_main,container,false);
        initViews();

        return view;
    }

    public void initViews(){
        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) view.findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.addFragment(new Fragment_aa(), "AAAAAA");
        myPagerAdapter.addFragment(new FragmentB(), "BB");
        mViewPager.setAdapter(myPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置Tab的图标，假如不需要则把下面的代码删去
        mTabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);



    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
