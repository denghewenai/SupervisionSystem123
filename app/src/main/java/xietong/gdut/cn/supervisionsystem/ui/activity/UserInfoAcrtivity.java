package xietong.gdut.cn.supervisionsystem.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import xietong.gdut.cn.supervisionsystem.R;

/**
 * 用户编辑个人信息界面
 * Created by 邓贺文 on 2016/1/19.
 */
public class UserInfoAcrtivity extends BaseActivity{

    private Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_userinfo;
    }

    @Override
    public void initViews() {

         mToolbar = (Toolbar) findViewById(R.id.id_toolbar_transparent);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout clp_Toolbar = (CollapsingToolbarLayout) findViewById(R.id.id_collapsingToobar);
        clp_Toolbar.setTitle("用户名");
        clp_Toolbar.setCollapsedTitleTextColor(Color.WHITE);
        clp_Toolbar.setExpandedTitleColor(Color.BLUE);

    }

    @Override
    public void initEvent() {

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
         protected void initFragment(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_userinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
