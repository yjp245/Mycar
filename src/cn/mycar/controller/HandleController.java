/**
 * Author:   JP
 * Date:     2018/10/17 0017 0:34
 * Description: 设备反向控制
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.udpserver.MyServletContextListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.DatagramSocket;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备反向控制〉
 *
 * @author JP
 * @create 2018/10/17 0017
 * @since 1.0.0
 */

@Controller
@RequestMapping("")
public class HandleController {


    @ResponseBody
    @RequestMapping("jsondata/handledevice.do")
   public String handle(HttpServletRequest request){
        //发送post请求时传个num数字过来     1  2  3  4  分别对应  BEEPON   BEEP
        String num=request.getParameter("num");
        if(num!=null){
            int n =Integer.parseInt(num);
            System.out.println(n);
            ServletContext context = MyServletContextListener.servletContext();
            DatagramSocket socket= (DatagramSocket) context.getAttribute("socket");
            MyServletContextListener.send(socket,n);
            return "ok";
        }
        return "false";
    }
    /*
    * 以下是测试使用*/
    @ResponseBody
    @RequestMapping("handledevice1.do")
    public String handle2(HttpSession session){

        int n=2;
        ServletContext context = MyServletContextListener.servletContext();
        DatagramSocket socket= (DatagramSocket) context.getAttribute("socket");
        MyServletContextListener.send(socket,n);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("handledevice2.do")
    public String handle3(HttpSession session){

        int n=3;
        ServletContext context = MyServletContextListener.servletContext();
        DatagramSocket socket= (DatagramSocket) context.getAttribute("socket");
        MyServletContextListener.send(socket,n);
        return "ok";
    }
}
