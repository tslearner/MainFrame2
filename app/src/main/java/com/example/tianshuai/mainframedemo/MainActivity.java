package com.example.tianshuai.mainframedemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.tianshuai.mainframedemo.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    private TabHost tabHost;
    private RadioGroup radiogroup;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_search:
                msg += "Click search";
                break;
            case R.id.action_add:
                msg += "Click add";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);


        // App Logo
      //  toolbar.setLogo(R.mipmap.chat_send_normal);
        // Title
        toolbar.setTitle("DEMO");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        // Sub Title
//        toolbar.setSubtitle("Sub title");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Navigation Icon
        toolbar.setNavigationIcon(R.mipmap.profile_card_company_icon);
        //toolbar.setOnMenuItemClickListener(onMenuItemClick);

       /* mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);*/
    }

    public void initView(){
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("main").setIndicator("main")
                .setContent(R.id.fragment_main));
        tabHost.addTab(tabHost.newTabSpec("mycenter").setIndicator("mycenter")
                .setContent(R.id.fragment_mycenter));
        tabHost.addTab(tabHost.newTabSpec("search").setIndicator("search")
                .setContent(R.id.fragment_search));
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int currentTab = tabHost.getCurrentTab();
                switch (checkedId) {
                    case R.id.radio_main:
                        tabHost.setCurrentTabByTag("main");

                        //如果需要动画效果就使用
                        //setCurrentTabWithAnim(currentTab, 0, "main");
                        getSupportActionBar().setTitle("首页");
                        break;
                    case R.id.radio_mycenter:
                        tabHost.setCurrentTabByTag("mycenter");
                        //setCurrentTabWithAnim(currentTab, 1, "mycenter");
                        getSupportActionBar().setTitle("个人中心");

                        break;
                    case R.id.radio_search:
                        tabHost.setCurrentTabByTag("search");
                        getSupportActionBar().setTitle("搜索");
                        break;
                }

            }
        });


    }


    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_search:
                    msg += "Click search";
                    break;
                case R.id.action_add:
                    msg += "Click add";
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
         * (只会在第一次初始化菜单时调用) Inflate the menu; this adds items to the action bar
        * if it is present.
         */
       getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }
}
