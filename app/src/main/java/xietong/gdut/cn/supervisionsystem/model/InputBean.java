package xietong.gdut.cn.supervisionsystem.model;

/**
 * Created by Administrator on 2016/1/20.
 */
public class InputBean {

    public static final int TYPE_WITHICON = 0;
    public static final int TYPE_SEPARATOR = 1;
    public static final int TYPE_NUMBER = 2;
    public static final int TYPE_JUSTEDIT = 3;
    public static final int TYPE_TEXT=4;


    private int type;

    private String name;

    private String content;

    public InputBean(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
