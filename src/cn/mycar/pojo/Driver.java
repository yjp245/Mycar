/**
 * Author:   JP
 * Date:     2018/8/28 0028 16:35
 * Description: 设备类
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备类 〉
 *
 * @author JP
 * @create 2018/8/28 0028
 * @since 1.0.0
 */

@Component
public class Driver {
    private int did;
    //设备id

    private int uid;
    //用户id

    private String dname;
   //设备名称

    private String dnum;
    //设备编号

    private String beizhu;

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getDnum() {
        return dnum;
    }

    public void setDnum(String dnum) {
        this.dnum = dnum;
    }

    private String dpass;
    //设备密码

    private String d_state;

  private int d_bind;
  //设备绑定


    public int getD_bind() {
        return d_bind;
    }

    public void setD_bind(int d_bind) {
        this.d_bind = d_bind;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDpass() {
        return dpass;
    }

    public void setDpass(String dpass) {
        this.dpass = dpass;
    }

    public String getD_state() {
        return d_state;
    }

    public void setD_state(String d_state) {
        this.d_state = d_state;
    }

    public Driver() {
        super();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "did=" + did +
                ", uid=" + uid +
                ", dname='" + dname + '\'' +
                ", dnum='" + dnum + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", dpass='" + dpass + '\'' +
                ", d_state='" + d_state + '\'' +
                ", d_bind=" + d_bind +
                '}';
    }
}
