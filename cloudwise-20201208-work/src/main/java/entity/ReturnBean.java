package entity;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/8 18:27
 * @description ：
 * @modified By：
 */
public class ReturnBean {
    private int code;
    private String msg;
    private int count;
    private Object data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
