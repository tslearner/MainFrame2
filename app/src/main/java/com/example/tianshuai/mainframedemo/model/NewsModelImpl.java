package com.example.tianshuai.mainframedemo.model;


import com.example.tianshuai.mainframedemo.fragment.NewsBean;
import com.example.tianshuai.mainframedemo.util.NewsJsonUtils;
import com.example.tianshuai.mainframedemo.util.OkHttpUtils;
import com.example.tianshuai.mainframedemo.util.Urls;

import java.util.List;

/**
 * Description : 新闻业务处理类
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/19
 */
public class NewsModelImpl implements NewsModel {

    /**
     * 加载新闻列表
     * @param url
     * @param listener
     */
    @Override
    public void loadNews(String url, final int type, final OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }


    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        /*switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                id = Urls.NBA_ID;
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                id = Urls.CAR_ID;
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                id = Urls.JOKE_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }*/
        id = Urls.TOP_ID;
        return id;
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }

}
