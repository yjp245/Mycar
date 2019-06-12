/**
 * Author:   JP
 * Date:     2018/8/27 0027 15:28
 * Description: 设备信息相关类
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

import org.springframework.stereotype.Component;

/**


 * 〈设备信息相关类〉
 *
 * @author JP
 * @create 2018/8/27 0027
 * @since 1.0.0
 */

@Component
public class DriverData {

    private int dataid;
    //设备数据id

    private  String dname;
  //设备编号 ,通过该字段查找设备信息

    private  int findperson;
    //是否有人

    private double mq2;
    //设备MQ2值

    private double mq135;
    //MQ135值

    private int temperature;
    //温度值

    private int  humidity;
    //湿度值

    private double latitude;
    //经度

    private double longitude;
     //纬度

    private  String time;
    //存入时间


    public DriverData(int dataid, String dname, int findperson, double mq2, double mq135, int temperature, int humidity, double latitude, double longitude, String time) {
        this.dataid = dataid;
        this.dname = dname;
        this.findperson = findperson;
        this.mq2 = mq2;
        this.mq135 = mq135;
        this.temperature = temperature;
        this.humidity = humidity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
        this.dataid = dataid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getFindperson() {
        return findperson;
    }

    public void setFindperson(int findperson) {
        this.findperson = findperson;
    }

    public double getMq2() {
        return mq2;
    }

    public void setMq2(double mq2) {
        this.mq2 = mq2;
    }

    public double getMq135() {
        return mq135;
    }

    public void setMq135(double mq135) {
        this.mq135 = mq135;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DriverData() {
        super();
    }

    @Override
    public String toString() {
        return "DriverData{" +
                "dataid=" + dataid +
                ", dname='" + dname + '\'' +
                ", findperson=" + findperson +
                ", mq2=" + mq2 +
                ", mq135=" + mq135 +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time='" + time + '\'' +
                '}';
    }
}
