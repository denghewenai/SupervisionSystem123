package xietong.gdut.cn.supervisionsystem.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import xietong.gdut.cn.supervisionsystem.app.App;

/**
 * Created by Administrator on 2016/1/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public App mApplication;
    public LayoutInflater mInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mApplication = App.getInstance();
        mInflater = LayoutInflater.from(this);

        initViews();
        initFragment(savedInstanceState);
        initEvent();
    }

    protected abstract void initFragment(Bundle savedInstanceState);


    /**
     * @return 返回一个布局ID
     */
    public abstract int getLayoutId() ;


    /**
     * 初始化视图
     */
    public abstract void initViews();

    /**
     * 注册点击事件
     */
    public abstract  void initEvent();

    /**
     * Activity切换
     * @param cla 要切换到的目标Activity.class
     */
    public void startAnimActivity(Class<?> cla) {
        this.startActivity(new Intent(this, cla));
    }


    /** 打印Log
     * ShowLog
     * @return void
     * @throws
     */
    public void showLog(String msg){
        Log.i("life", msg);
    }

    public void showToast(String info){
        Toast.makeText(BaseActivity.this, info, Toast.LENGTH_SHORT).show();
    }


}
