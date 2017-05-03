package com.example.tianshuai.mainframedemo.contracts;

import com.example.tianshuai.mainframedemo.fragment.NewsBean;

import java.util.List;

/**
 * Created by tianshuai on 2017/5/3.
 */

public interface NewsContract {

    interface View{
        void showProgress();

        void addNews(List<NewsBean> newsList);

        void hideProgress();

        void showLoadFailMsg();
    }
    interface Presenter  {
        void loadNews(int type, int page);
    }
}
