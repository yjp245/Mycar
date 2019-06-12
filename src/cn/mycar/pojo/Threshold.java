package cn.mycar.pojo;

/**
 * @author JP
 * @title: Threshold
 * @projectName 家用燃氣1.1
 * @description: 设备阈值类
 * @date 2019/4/18 0018
 */

public class Threshold {

    //序号
    private int id;
    //用户id
    private int uid;
    //设备号
    private String dnum;
    //mq2阈值
    private double mq2_s;
    //mq7阈值
    private double wendu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDnum() {
        return dnum;
    }

    public void setDnum(String dnum) {
        this.dnum = dnum;
    }

    public double getMq2_s() {
        return mq2_s;
    }

    public void setMq2_s(double mq2_s) {
        this.mq2_s = mq2_s;
    }

    public double getWendu() {
        return wendu;
    }

    public void setWendu(double wendu) {
        this.wendu = wendu;
    }



    @Override
    public String toString() {
        return "Threshold{" +
                "id=" + id +
                ", uid=" + uid +
                ", dnum='" + dnum + '\'' +
                ", mq2_s=" + mq2_s +
                ", wendu=" + wendu +
                '}';
    }
}
