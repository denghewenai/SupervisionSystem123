package xietong.gdut.cn.supervisionsystem.adapter;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

import xietong.gdut.cn.supervisionsystem.R;
import xietong.gdut.cn.supervisionsystem.model.InputBean;

/**
 * Created by Administrator on 2016/1/20.
 */
public class ListViewAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private Context mContext;
    private List<InputBean> mDatas;

    public ListViewAdapter( Context context, List<InputBean> datas) {

        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            switch (getItemViewType(position)){

                case InputBean.TYPE_WITHICON:
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.listitem_withicon,null);
                    holder.hint = (TextInputLayout) convertView.findViewById(R.id.id_inputLayout_withIcon);
                    holder.editText = (EditText) convertView.findViewById(R.id.id_editText_withIcon);
                    break;
                case InputBean.TYPE_SEPARATOR:
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.listitem_separator,null);
                    holder.view = convertView.findViewById(R.id.id_separator);
                    break;
                case InputBean.TYPE_JUSTEDIT:
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.listitem_justedit,null);
                    holder.hint = (TextInputLayout) convertView.findViewById(R.id.id_inputLayout_justEdit);
                    holder.editText = (EditText) convertView.findViewById(R.id.id_editText_justEdit);
                    break;
            }
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        if(holder.editText != null){
            holder.hint.setHint(mDatas.get(position).getName());
        }
        return convertView;
    }

    public final class ViewHolder{

        public TextInputLayout hint;
        public EditText editText;
        public View view;

    }

}
