package com.example.tianshuai.mainframedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tianshuai.mainframedemo.NewsAdapter;
import com.example.tianshuai.mainframedemo.Presenter.NewsPresenterImpl;
import com.example.tianshuai.mainframedemo.R;
import com.example.tianshuai.mainframedemo.contracts.NewsContract;
import com.example.tianshuai.mainframedemo.util.Urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianshuai on 2017/5/2.
 */

public class Fragment_aa  extends Fragment implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener {
    private String context;
    private TextView mTextView;
    private static final String TAG = "Fragment_aa";

    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private NewsAdapter mAdapter;
    private List<NewsBean> mData;
    private NewsContract.Presenter mNewsPresenter;

    private int mType = 0;
    private int pageIndex = 0;

    public  Fragment_aa(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aa,container,false);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NewsAdapter(getActivity().getApplicationContext());
       // mAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mNewsPresenter = new NewsPresenterImpl(this);
        onRefresh();
        return view;
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount()
                    && mAdapter.isShowFooter()) {
                //加载更多
                Log.d(TAG, "loading more data");
                mNewsPresenter.loadNews(mType, pageIndex + Urls.PAZE_SIZE);
            }
        }
    };

    @Override
    public void onRefresh() {
        pageIndex = 0;
        if(mData != null) {
            mData.clear();


        }
        mNewsPresenter.loadNews(mType, pageIndex);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void addNews(List<NewsBean> newsList) {
        mAdapter.isShowFooter(true);
        if(mData == null) {
            mData = new ArrayList<NewsBean>();
        }
        mData.addAll(newsList);
       /* if(pageIndex == 0) {
            mAdapter.setmDate(mData);
        } else {
            //如果没有更多数据了,则隐藏footer布局
            if(newsList == null || newsList.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }*/
        if(newsList == null || newsList.size() == 0) {
           // mAdapter.isShowFooter(false);
            mAdapter.setIsEnd(true);
        }else{
            mAdapter.setIsEnd(false);
        }
        mAdapter.setmDate(mData);
        pageIndex += Urls.PAZE_SIZE;
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {
        if(pageIndex == 0) {
            mAdapter.isShowFooter(false);
            mAdapter.notifyDataSetChanged();
        }
      //  View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
        //Snackbar.make(view, "fail", Snackbar.LENGTH_SHORT).show();
    }
}