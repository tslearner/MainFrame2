package com.example.tianshuai.mainframedemo.model;

/**
 * Description :
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/19
 */
public interface NewsModel {

    void loadNews(String url, int type, OnLoadNewsListListener listener);



}
