package xietong.gdut.cn.supervisionsystem.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import xietong.gdut.cn.supervisionsystem.R;

/**
 * Created by 邓贺文 on 2016/1/19.
 *普通督导Fragment
 */
public class GeneralFragment extends BaseFragment{

    private TextInputLayout mSchool;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_general;
    }

    @Override
    protected void initViews(View mContentView) {

        mSchool = (TextInputLayout) findViewById(R.id.id_school);


    }

    @Override
    public void initEvents(Bundle savedInstanceState) {

    }
}
