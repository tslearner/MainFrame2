[1mdiff --git a/app/src/main/java/com/example/tianshuai/mainframedemo/MainActivity.java b/app/src/main/java/com/example/tianshuai/mainframedemo/MainActivity.java[m
[1mindex 47147df..7cfdfcd 100644[m
[1m--- a/app/src/main/java/com/example/tianshuai/mainframedemo/MainActivity.java[m
[1m+++ b/app/src/main/java/com/example/tianshuai/mainframedemo/MainActivity.java[m
[36m@@ -3,6 +3,8 @@[m [mpackage com.example.tianshuai.mainframedemo;[m
 import android.app.Activity;[m
 import android.app.Fragment;[m
 import android.content.Intent;[m
[32m+[m[32mimport android.support.v4.widget.DrawerLayout;[m
[32m+[m[32mimport android.support.v7.app.ActionBarDrawerToggle;[m
 import android.support.v7.app.AppCompatActivity;[m
 import android.os.Bundle;[m
 import android.support.v7.widget.Toolbar;[m
[36m@@ -20,6 +22,8 @@[m [mimport com.example.tianshuai.mainframedemo.fragment.MainFragment;[m
 public class MainActivity extends AppCompatActivity {[m
     private TabHost tabHost;[m
     private RadioGroup radiogroup;[m
[32m+[m[32m    private DrawerLayout mDrawerLayout;[m
[32m+[m[32m    private ActionBarDrawerToggle mDrawerToggle;[m
 [m
     @Override[m
     protected void onCreate(Bundle savedInstanceState) {[m
[36m@@ -50,6 +54,8 @@[m [mpublic class MainActivity extends AppCompatActivity {[m
 [m
     public void initToolbar(){[m
         Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);[m
[32m+[m
[32m+[m
         // App Logo[m
       //  toolbar.setLogo(R.mipmap.chat_send_normal);[m
         // Title[m
[36m@@ -62,6 +68,12 @@[m [mpublic class MainActivity extends AppCompatActivity {[m
         //Navigation Icon[m
         toolbar.setNavigationIcon(R.mipmap.profile_card_company_icon);[m
         //toolbar.setOnMenuItemClickListener(onMenuItemClick);[m
[32m+[m
[32m+[m[32m       /* mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);[m
[32m+[m[32m        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,[m
[32m+[m[32m                R.string.drawer_close);[m
[32m+[m[32m        mDrawerToggle.syncState();[m
[32m+[m[32m        mDrawerLayout.setDrawerListener(mDrawerToggle);*/[m
     }[m
 [m
     public void initView(){[m
[1mdiff --git a/app/src/main/java/com/example/tianshuai/mainframedemo/NewsAdapter.java b/app/src/main/java/com/example/tianshuai/mainframedemo/NewsAdapter.java[m
[1mindex 22e31f3..8ff6748 100644[m
[1m--- a/app/src/main/java/com/example/tianshuai/mainframedemo/NewsAdapter.java[m
[1m+++ b/app/src/main/java/com/example/tianshuai/mainframedemo/NewsAdapter.java[m
[36m@@ -22,6 +22,8 @@[m [mimport java.util.List;[m
 public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {[m
     private static final int TYPE_ITEM = 0;[m
     private static final int TYPE_FOOTER = 1;[m
[32m+[m
[32m+[m
     private Boolean isEnd=false;[m
 [m
     private List<NewsBean> mData;[m
[1mdiff --git a/app/src/main/res/layout/activity_main.xml b/app/src/main/res/layout/activity_main.xml[m
[1mindex 1332fe0..f1d1a62 100644[m
[1m--- a/app/src/main/res/layout/activity_main.xml[m
[1m+++ b/app/src/main/res/layout/activity_main.xml[m
[36m@@ -1,14 +1,18 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"[m
     xmlns:tools="http://schemas.android.com/tools"[m
[32m+[m[32m    xmlns:app="http://schemas.android.com/apk/res-auto"[m
     android:layout_width="match_parent"[m
     android:layout_height="match_parent"[m
     android:orientation="vertical"[m
[32m+[m[32m    android:id="@+id/drawer_layout"[m
[32m+[m[32m    android:fitsSystemWindows="true"[m
     tools:context="com.example.tianshuai.mainframedemo.MainActivity">[m
[31m-[m
     <include android:id="@+id/id_toolbar"[m
         layout="@layout/tool_bar_layout"/>[m
     <include android:id="@+id/tabhost"[m
[31m-        layout="@layout/tabhost"/>[m
[32m+[m[32m        layout="@layout/tabhost"[m
[32m+[m[32m       />[m
[32m+[m
 [m
 </LinearLayout>[m
[1mdiff --git a/app/src/main/res/layout/tool_bar_layout.xml b/app/src/main/res/layout/tool_bar_layout.xml[m
[1mindex ebeb68e..701bc59 100644[m
[1m--- a/app/src/main/res/layout/tool_bar_layout.xml[m
[1m+++ b/app/src/main/res/layout/tool_bar_layout.xml[m
[36m@@ -5,7 +5,5 @@[m
     android:id="@+id/id_toolbar"[m
     android:layout_width="match_parent"[m
     android:layout_height="wrap_content"[m
[31m-    app:layout_scrollFlags="scroll|enterAlways"[m
     android:minHeight="?attr/actionBarSize"[m
[31m-[m
[31m-    android:background="#00000000"/>[m
\ No newline at end of file[m
[32m+[m[32m    android:background="#00000000"/>[m
[1mdiff --git a/app/src/main/res/values/strings.xml b/app/src/main/res/values/strings.xml[m
[1mindex 4bc5199..dc9321e 100644[m
[1m--- a/app/src/main/res/values/strings.xml[m
[1m+++ b/app/src/main/res/values/strings.xml[m
[36m@@ -1,3 +1,5 @@[m
 <resources>[m
     <string name="app_name">MainFrameDemo</string>[m
[32m+[m[32m    <string name="drawer_open">Open</string>[m
[32m+[m[32m    <string name="drawer_close">Close</string>[m
 </resources>[m
