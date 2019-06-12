package cn.mycar.pojo;

import java.io.Serializable;


/**
 * 〈用户登录类  〉<br>
 * 属性： 登录ID
 *       登录账户
 *       密码
 *       登录状态
 *      登录角色
 *
 * @author JP
 * @create 2018/8/28 0028
 * @since 1.0.0
 */

public class Login implements Serializable {

    private int l_id;
    private String l_user;
    private String l_pass;
    private String l_state;
    //登录状态  on_line  或 off_line

    private String l_rights;
   //登录角色  普通user   管理admin

    private String ip;
    private String time;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Login(int l_id, String l_user, String l_pass, String l_state, String l_rights) {
        this.l_id = l_id;
        this.l_user = l_user;
        this.l_pass = l_pass;
        this.l_state = l_state;
        this.l_rights = l_rights;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getL_user() {
        return l_user;
    }

    public void setL_user(String l_user) {
        this.l_user = l_user;
    }

    public String getL_pass() {
        return l_pass;
    }

    public void setL_pass(String l_pass) {
        this.l_pass = l_pass;
    }

    public String getL_state() {
        return l_state;
    }

    public void setL_state(String l_state) {
        this.l_state = l_state;
    }

    public String getL_rights() {
        return l_rights;
    }

    public void setL_rights(String l_rights) {
        this.l_rights = l_rights;
    }

    public Login() {
        super();
    }

    @Override
    public String toString() {
        return "Login{" +
                "l_id=" + l_id +
                ", l_user='" + l_user + '\'' +
                ", l_pass='" + l_pass + '\'' +
                ", l_state='" + l_state + '\'' +
                ", l_rights='" + l_rights + '\'' +
                ", ip='" + ip + '\'' +
                ", time='" + time + '\'' +
                ", count=" + count +
                '}';
    }
}
