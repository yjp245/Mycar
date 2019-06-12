/**
 * Author:   JP
 * Date:     2018/8/28 0028 16:20
 * Description: 接收数据线程
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.udpserver;

/**
 * 〈一句话功能简述〉<br> 
 * 〈接收数据线程〉
 *
 * @author JP
 * @create 2018/8/28 0028
 * @since 1.0.0
 */

import cn.hutool.core.util.RandomUtil;
import cn.mycar.pojo.Driver;
import cn.mycar.pojo.DriverData;
import cn.mycar.pojo.Threshold;
import cn.mycar.service.DriverDataService;
import cn.mycar.service.DriverService;
import cn.mycar.service.ThresholdService;
import cn.mycar.util.AliyunSms;
import cn.mycar.util.Dateandtime;
import cn.mycar.util.LoadUtils;
import cn.mycar.util.PushtoSingle;

import javax.servlet.ServletContext;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecieveThread extends Thread{



    // public  static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
    //获取配置文件


    //public static  DriverDataService driverDataService=(DriverDataService)context.getBean("driverdataservice");


    //注入设备数据业务

    public static  DriverDataService driverDataService=(DriverDataService)LoadUtils.getSpringBean("driverdataservice");

    public static DriverService driverService=(DriverService)LoadUtils.getSpringBean("driverservice");
    public static ThresholdService thresholdService=(ThresholdService)LoadUtils.getSpringBean("threshold");
    //之前时间
    private static String before="2019-4-16 21:06:30";
    //次数
    private static int count=0;
    //标记变量
    private static boolean flag=false;

    private  DatagramSocket socket;
    private ServletContext context;

    public RecieveThread(DatagramSocket socket,ServletContext context) {
        // TODO Auto-generated constructor stub
        this.socket=socket;
        this.context=context;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        execute(socket,context);

    }
    // 处理通信细节的静态方法，这里主要是方便线程池服务器的调用

    public static void execute(DatagramSocket socket,ServletContext context) {


        try {

            byte[] bs=new byte[1024*64];
            //新建字节数组暂存数据
            DatagramPacket packet=new DatagramPacket(bs, bs.length);
            //新建一个数据报对象

            while(true) {

                socket.receive(packet);
                //读取消息
                if(null!=packet){
                    //不为空就显示的消息
                    try {

                        String str=new String(bs, 0, packet.getLength());


                        //
                        System.err.println("接收到来自NB平台信息："+str);

                        String ss1[]=str.split("#");

                        DriverData driverData=new DriverData();
                        driverData.setDname(ss1[1]);
                        driverData.setFindperson(Integer.parseInt(ss1[2]));
                        driverData.setTemperature(Integer.parseInt(ss1[3]));
                        driverData.setHumidity(Integer.parseInt(ss1[4]));
                        driverData.setMq2(Double.parseDouble(ss1[5]));
                        driverData.setMq135(Double.parseDouble(ss1[6]));
                        driverData.setLongitude(Double.parseDouble(updemo(ss1[7])));
                        driverData.setLatitude(Double.parseDouble(updemo(ss1[8])));

                        driverData.setTime(Dateandtime.Datetime());

                        //数据库添加数据
                        driverDataService.addDriver(driverData);

                        //通过设备号查询阈值设置
                          Threshold threshold= thresholdService.selectByDnum(driverData.getDname());

                        System.out.println("接收设备数据"+driverData.toString());
                        Driver driver1=driverService.findDriver(driverData.getDname());

                        if(driver1 != null){
                            driver1.setD_state("在线");
                            context.setAttribute("nowDriverdata",driverData);
                            //如果阈值配置不为空
                            if(threshold!=null){
                                if(driverData.getMq2()>threshold.getMq2_s()){
                                    PushtoSingle.toAPP("车内出现烟雾值，请查看是否有火灾！！！");
                                    sendMsg();
                                }
                                if(driverData.getMq135()>=2){
                                    PushtoSingle.toAPP("车内空气质量过低！！！");
                                    sendMsg();
                                }
                                if(driverData.getTemperature()>=threshold.getWendu()){
                                    PushtoSingle.toAPP("当前车内环境温度过高！！！");
                                    sendMsg();
                                }
                            }
                            driverService.update(driver1);
                        }else{
                            driver1.setD_state("离线");
                            context.setAttribute("nowDriverdata",null);
                            driverService.update(driver1);
                        }


                        //设置属性传递实时数据值可在 servlet 、controller 内调用

                        // 获取方法列如：  DriverData driverData=(DriverData)context.getAttribute("nowDriverdata");

                        // System.out.println(driverData.toString());

                    } catch (Exception e) {
                        // TODO: handle exception

                    }

                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    /**
     *
     * @param str
     * @return
     */
    public static String updemo(String str){
        return   str+RandomUtil.randomInt(7800,8000);
    }

    /**
     *  限制两分钟发送一次短信
     * @throws Exception
     */
    public static void sendMsg()throws Exception{

        if(!flag) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=sdf.parse(before);
            Date date1=new Date();

            long time=(date1.getTime()-date.getTime())/60000; //获取分钟数
            Thread.sleep(5000);
            // System.out.println("当前时间为"+sdf.format(date1)+" 之前时间为"+before+" "+"时间差为"+time+" ");

            //大于2分钟
            if (time >= 2) {

                before=sdf.format(new Date());

                //   System.out.println("#########时间大于两分钟了,可以发一次短信了###########"+"且发了"+count+"一次");
                AliyunSms.sendSmsMsg("15080558770","当前车内环境状况异常！！！");


            }
        }


    }


    /**
     * 通过设备编号查询阈值
     * @param dnum
     * @return
     */
    public static Threshold selectByDnum(String dnum){
        return thresholdService.selectByDnum(dnum);
    }
}
