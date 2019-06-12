/**
 * Author:   JP
 * Date:     2018/8/30 0030 19:56
 * Description: 管理员类
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理员类 〉
 *
 * @author JP
 * @create 2018/8/30 0030
 * @since 1.0.0
 */

public class Admin {
    private int aid;
    //管理员编号

    private String aname;
    //姓名

    private String aphone;
    //管理员电话

    private int l_id;
    /*登录 l_id 外键*/

    public Admin(int aid, String aname, String aphone, int l_id) {
        this.aid = aid;
        this.aname = aname;
        this.aphone = aphone;
        this.l_id = l_id;
    }

    public Admin() {
        super();
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", aphone='" + aphone + '\'' +
                ", l_id=" + l_id +
                '}';
    }
}
