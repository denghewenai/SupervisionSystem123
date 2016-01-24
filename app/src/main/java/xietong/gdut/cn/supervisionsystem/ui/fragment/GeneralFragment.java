package xietong.gdut.cn.supervisionsystem.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import xietong.gdut.cn.supervisionsystem.R;
import xietong.gdut.cn.supervisionsystem.adapter.ListViewAdapter;
import xietong.gdut.cn.supervisionsystem.config.Config;
import xietong.gdut.cn.supervisionsystem.model.InputBean;

/**
 * Created by 邓贺文 on 2016/1/19.
 *普通督导Fragment
 */
public class GeneralFragment extends BaseFragment{

    private ListView mListView;
    private ListViewAdapter mAdapter;
    private List<InputBean> mDatas;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_general;
    }

    @Override
    protected void initViews(View mContentView) {

        mListView = (ListView) findViewById(R.id.id_lv_general);
        mDatas = new ArrayList<InputBean>();
        initDatas();
        mAdapter = new ListViewAdapter(getActivity(),mDatas);
        mListView.setAdapter(mAdapter);

    }


    @Override
    public void initEvents(Bundle savedInstanceState) {

//        mListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                mListView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//                EditText editText = null;
//                if (position > 5) {
//                    editText = (EditText) view.findViewById(R.id.id_editText_justEdit);
//                }else if(position < 5){
//                    editText = (EditText) view.findViewById(R.id.id_editText_withIcon);
//                }
//                editText.requestFocus();
//                editText.setFitsSystemWindows(true);
//                editText.setKeepScreenOn(true);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                mListView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
//            }
//        });

    }

    private void initDatas() {


        for (String withIcon_content:Config.WITHICON_FIRST){
            InputBean input = new InputBean(InputBean.TYPE_WITHICON,withIcon_content);
            mDatas.add(input);
        }

        for (String justEdit_content:Config.JUSTEDIT_CONTENT) {

            InputBean input = new InputBean(InputBean.TYPE_JUSTEDIT,justEdit_content);
            mDatas.add(input);

        }

        for (String withIcon_content:Config.WITHICON_CONTENT){
            InputBean input = new InputBean(InputBean.TYPE_WITHICON,withIcon_content);
            mDatas.add(input);
        }

//        InputBean separator = new InputBean(InputBean.TYPE_SEPARATOR,"");
//        mDatas.add(separator);

    }

}
