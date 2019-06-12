package cn.mycar.pojo;

import java.io.Serializable;

/**
 * 〈用户信息类  〉<br>
 * 属性： 用户ID
 *       用户名
 *       电话
 *       邮箱
 *      登录ID
 *
 *
 * @author JP
 * @create 2018/8/28 0028
 * @since 1.0.0
 */
public class User implements Serializable {
   private int uid;
   /*用户uid*/

   private String uname;
   /* 用户名，昵称*/

    private String usex;
    /*性别*/

    private String uphone;

    private String uemail;

    private int l_id;
    /*登录 l_id 外键*/

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public User(int uid, String uname, String usex, String uphone, String uemail, int l_id) {
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
        this.uphone = uphone;
        this.uemail = uemail;
        this.l_id = l_id;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uemail='" + uemail + '\'' +
                ", l_id=" + l_id +
                '}';
    }
}
