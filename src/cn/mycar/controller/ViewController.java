package cn.mycar.controller;

import cn.mycar.pojo.DriverData;
import cn.mycar.pojo.Log4;
import cn.mycar.pojo.User;
import cn.mycar.service.DriverDataService;
import cn.mycar.udpserver.MyServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;
import java.util.List;

@Controller


@RequestMapping("")
/**
 * Demo class
 *
 * @author JS
 * @date 2018/8/6
 */
public class ViewController {

    /*调用日志*/

    Log4 log4 = new Log4(this.getClass());

    @Autowired
    DriverDataService driverDataService;

    /**
     * 处理/main 请求，前去主界面 view/index
     */
    @RequestMapping("/main.do")
    public String main(HttpSession session) throws Exception {
        int state = (int) session.getAttribute("loginRights");

        if (state == 1) {
            //1代表普通用户等级，跳转到用户欢迎系统
            return "main";
        } else {
            //2 代表管理员用户等级，跳转到管理员界面
            return "main2";
        }
    }

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }



}
