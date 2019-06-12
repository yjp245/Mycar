/**
 * Author:   JP
 * Date:     2018/9/4 0004 23:08
 * Description: ServletContext 被 Servlet 程序用来与 Web 容器通信。例如写日志，转发请求。
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.udpserver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 〈一句话功能简述〉<br> 
 * 〈ServletContext 被 Servlet 程序用来与 Web 容器通信。例如写日志，转发请求。〉
 *
 * @author JP
 * @create 2018/9/4 0004
 * @since 1.0.0
 *
 * ServletContextListener接口用于tomcat启动时自动加载函数，方法如下：
 * 一、需加载的类必须实现ServletContextListener接口。
 * 二、该接口中有两个方法必须实现：
 * 1、contextInitialized(ServletContextEvent sce)该方法为服务器起动时加载内容。
 * 2、contextDestroyed(ServletContextEvent sce)该方法为服务器关闭时加载的内容。
 */

public class MyServletContextListener implements ServletContextListener {

    public static String ServerIp="115.29.240.46";
    //UDPIp

    public  static int port=6000;
    //端口

    public static ServletContext context = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

         context=servletContextEvent.getServletContext();
        // TODO Auto-generated method stub
        try {

            String str="ep=B2LGZ3CRUFNKZEPY&pw=153212";
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(ServerIp), port);
            DatagramSocket socket=new DatagramSocket();


            System.out.println("初始化socket.....Start!");
            socket.send(datagramPacket);

            context.setAttribute("socket",socket);


           // new SendThread(socket).start();
            // 启动发送消息线程 发送的被我注销了没写反向控制

            System.out.println("数据处理任务开始运行");

            new RecieveThread(socket,context).start();
            // 启动接受消息线程

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    //返回context 供 controller使用

    public static ServletContext servletContext(){
         return context;
    }

    /**
     * 发送指令
     * */

    public static void send(DatagramSocket socket,int n) {
        String ServerIp="115.29.240.46";//
        int port=6000;//端口
        String str="";
      switch (n){
          case 1:
              str="LED_ON" ;break;
          case 2:
              str="LEDOFF" ;break;
          case 3:
              str="BEEPON" ;break;
          case 4:
              str="BEEPOF" ;break;

          default:  break;
      }
        try {
                DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(ServerIp), port);
                socket.send(datagramPacket);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
