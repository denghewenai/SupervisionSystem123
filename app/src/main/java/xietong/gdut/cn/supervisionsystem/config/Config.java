package xietong.gdut.cn.supervisionsystem.config;

/**
 * Created by Administrator on 2016/1/21.
 */
public class Config {

    public static final int INPUT_ALL_NUMBER = 20;
    public static final int INPUT_WITHICON_NUMBER = 5;
    public static final int INPUT_JUSTEDIT_NUMBER = 15;

    public static String[] WITHICON_FIRST = {"校区  *必填","日期  *必填","节次  *必填",
            "上课地点  *必填","老师是否按时情况 *必填"};


    public static String[] JUSTEDIT_CONTENT={"学院名称  *必填","教师名字  *必填",
            "教学班组成  *必填", "督导时间  可选","其他情况  可选","督导员签名  *必填"};

    public static String[] WITHICON_CONTENT = {"应到人数  *必填","实际人数  *必填",
            "迟到早退情况(填人数)  *必填","旷课情况(填人数)  *必填","请假情况(填人数)  *必填",
            "玩手机情况(填人数)  *必填","吃东西情况(填人数)  *必填",
            "睡觉、讲话情况(填人数)  *必填","穿拖鞋、短裤情况(填人数)  *必填"};
}
