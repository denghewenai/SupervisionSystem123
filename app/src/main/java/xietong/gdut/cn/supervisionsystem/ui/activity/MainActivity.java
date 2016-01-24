package xietong.gdut.cn.supervisionsystem.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import xietong.gdut.cn.supervisionsystem.R;
import xietong.gdut.cn.supervisionsystem.ui.fragment.HomeFragment;
import xietong.gdut.cn.supervisionsystem.ui.fragment.NewsFragment;
import xietong.gdut.cn.supervisionsystem.ui.fragment.QueryFragment;

public class MainActivity extends BaseActivity {

    private ImageView mHead;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;

    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private QueryFragment queryFragment;

    private Fragment nowFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

        mHead = (ImageView) findViewById(R.id.id_nv_headphoto);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigationView);

        setSupportActionBar(mToolbar);
        final ActionBar mActionBar = getSupportActionBar();

        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,mToolbar,R.string.open,R.string.close);
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);

        mNavigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {

        //判断activity是否重建，如果不是，则不需要重新建立fragment.
        if(savedInstanceState==null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if(homeFragment==null) {
                homeFragment = new HomeFragment();
            }
            nowFragment = homeFragment;
            ft.replace(R.id.id_frameMain, homeFragment).commit();
        }

    }

    @Override
    public void initEvent() {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                String title = (String) menuItem.getTitle();
                menuItem.setChecked(true);
                restoreTitle(title);

                switch (title){
                    case "主页":
                        if(homeFragment == null){
                            homeFragment = new HomeFragment();
                        }
                    swichContent(nowFragment,homeFragment);
                        break;
                    case "校内新闻":
                        if(newsFragment == null){
                            newsFragment = new NewsFragment();
                        }
                        swichContent(nowFragment,newsFragment);
                        break;
                    case "成绩查询":
                        if(queryFragment == null){
                            queryFragment = new QueryFragment();
                        }
                        swichContent(nowFragment,queryFragment);
                        break;
                    case "设置":
                        startAnimActivity(SetActivity.class);
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        mHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimActivity(UserInfoAcrtivity.class);
            }
        });

    }

    /**
     *  当fragment进行切换时，
     *  采用隐藏与显示的方法加载fragment
     *  以防止数据的重复加载
     * @param from 当前Fragment
     * @param to 要显示的Fragment
     */
    private void swichContent(Fragment from, Fragment to) {

        if(nowFragment != to){
            nowFragment = to;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(!to.isAdded()){
            // 隐藏当前的fragment，add下一个到Activity中
            ft.hide(from).add(R.id.id_frameMain,to).commit();
        }else{
            // 隐藏当前的fragment，显示下一个
            ft.hide(from).show(to).commit();
        }

    }

    private void restoreTitle(CharSequence title) {

        if(TextUtils.isEmpty(title)){
            mToolbar.setTitle("主页");
            return;
        }

        mToolbar.setTitle(title);
    }

    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
