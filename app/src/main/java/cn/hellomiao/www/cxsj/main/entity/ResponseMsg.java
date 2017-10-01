package cn.hellomiao.www.cxsj.main.entity;

/**
 * Created by liwenban on 2017/10/1.
 */

public class ResponseMsg {

    private int status;
    private String msg;

    public ResponseMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseMsg(){}
}
