package cn.mycar.controller;

import cn.hutool.core.date.DateUtil;
import cn.mycar.pojo.*;
import cn.mycar.service.AdminService;
import cn.mycar.service.DriverDataService;
import cn.mycar.service.LoginService;
import cn.mycar.service.UserService;
import cn.mycar.util.*;
import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
/**
 * 用户登录控制
 */
public class LoginController {

    @Autowired
    DriverDataService driverDataService;

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

   @Autowired
    AdminService adminService;

    /*调用日志*/

    Log4 log4 = new Log4(this.getClass());

    /**
     * 登录认证,根据登录请求返回事件。验证成功，欢迎界面，验证失败，登录界面
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String login1(Model model, HttpSession session, Login login) {
        log4.info("WEB端 ------登录模块初始化 ---获取到用户名为" + login.getL_user());

        String pass = loginService.findPass(login.getL_user());
        //查询密码不为空 ，判断是否与输入密码相同
        if (pass != null) {
            String md5pass = AppMD5Util.getMD5(login.getL_pass());
            //若输入密码匹配正确，则更改用户登录状态，同时获取账户信息
            if (pass.equals(md5pass)) {

                //通过账号获取登录对象
                Login newLogin=loginService.get(login.getL_user());


                newLogin.setIp(login.getIp());
                newLogin.setCount(newLogin.getCount()+1);
                newLogin.setL_state("on-line");
                //更改账户状态，设置为在线
                session.setAttribute("login_pojo",newLogin);
                loginService.update(newLogin);
                String rights=newLogin.getL_rights();
                // 获取账户角色
                if("user".equals(rights)){

                    User userinfo = userService.getUserbyLid(newLogin.getL_id());
                    //通过登录liD去查询用户信息
                      // log4.info(userinfo.toString());

                    //通过session传值  账户角色: 1 代表普通账户  账户信息
                    session.setAttribute("loginRights",1);
                    session.setAttribute("loginUser",login.getL_user());
                    session.setAttribute("loginUserUid",userinfo.getUid());

                    session.setAttribute("loginUserInfo", userinfo);

                }
                if("admin".equals(rights)){

                    //获取管理员信息
                    Admin admininfo=adminService.getAdminbyLid(newLogin.getL_id());
                   // log4.info(admininfo.toString());
                    session.setAttribute("loginRights",2);
                    session.setAttribute("loginUser",login.getL_user());
                    session.setAttribute("loginUserInfo", admininfo);



                }

               //重定向到主界面
                return "redirect:/main.do";
            } else {
                model.addAttribute("loginerro", "密码输入错误，请核对后输入");
                return "login";
            }
        } else {
            model.addAttribute("loginerro", "用户不存在,请前去 <a href='register.jsp'>注册</a>");
            return "login";
        }
    }

    /**
     * 去登录界面
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }


    /**
     * 退出账户
     **/
    @RequestMapping("/logoOut.do")
    public String loginout(HttpSession session) throws Exception {

       String loginUser=(String)session.getAttribute("loginUser");
        Login newLogin=loginService.get(loginUser);
        newLogin.setL_state("off-line");
        newLogin.setTime(Dateandtime.Datetime());
        //更改账户状态，设置为离线
        loginService.update(newLogin);
        
        session.invalidate();
        //清除session
        return "redirect:/index.jsp";
    }

    /**
     * 修改用户信息
     *电话
     * 昵称
     * 邮箱
     */
  @ResponseBody
  @RequestMapping("/jsondata/updateUserInfo.do")
   public String updateUserInfo(HttpServletRequest request,HttpSession session){
    String uname=request.getParameter("uname");
    String uphone=request.getParameter("uphone");
    String uemail=request.getParameter("uemail");
    String uid=request.getParameter("uid");

    User user=userService.getUserbyUid(Integer.parseInt(uid));
      System.out.println(user.toString());
    user.setUemail(uemail);
     user.setUphone(uphone);
    user.setUname(uname);
      userService.update(user);
      return "ok";
  }


    /**
     * 修改用户密码
     * password
     */
    @ResponseBody
   @RequestMapping("updateUserPass.do")
   public String updataUserPass(String pass,HttpSession session){
        Login login=(Login)session.getAttribute("login_pojo");
        String password=AppMD5Util.getMD5(pass);
        login.setL_pass(password);
        loginService.update(login);
       return "ok";
   }

    /**
     * APP登录验证
     * 传入登录账户、密码
     * 返回 nullfalse、
     *      passfalse
     * Login 对象
     *
     */
    @ResponseBody
    @RequestMapping("jsondata/loginapi.do")
    public String appLogin(HttpServletRequest request, HttpSession session) {
        String loginname = request.getParameter("uname");
        String loginpass = request.getParameter("upass");
        Login rlogin = null;
        /*  System.out.println("客户端登录api模块初始化-----获取到用户登录信息" + loginname + " " + loginpass);*/
        log4.info("客户端登录api模块初始化-----获取到用户登录信息" + loginname + " " + loginpass);

        /*
         * 查询密码*/
        if (loginname != null && loginpass != null) {
            String findpass = loginService.findPass(loginname);
            System.out.println("查询到的密码"+findpass);
            if (findpass != null) {
                //用户是否存在

                /* loginpass = AppMD5Util.getMD5(loginpass);*/

                if (findpass.equals(loginpass)) {
                    //密码匹配
                    rlogin = loginService.get(loginname);

                    int l_id = rlogin.getL_id();

                    //通过登录账户获取登录ID号
                    User userinfo = userService.getUserbyLid(l_id);
                    System.out.println(userinfo.toString());
                    session.setAttribute("loginUserInfo", userinfo);
                    //获取用户信息
                    log4.info("用户登录成功");

                    return JSON.toJSONString(userinfo);
                    //回传用户信息--字符类型
                } else {
                    log4.info("用户密码错误");
                    return "passfalse";
                    //密码错误
                }
            } else {
                log4.info("用户不存在");
                return "nullfalse";
                //账户不存在
            }
        } else {
            return "null";
        }
    }

    /*
     * 客户端APP注册账户
     * 传入登录账户、密码
     * */

    @ResponseBody
    @RequestMapping("jsondata/registerapi.do")
    public String appRegister(HttpServletRequest request, HttpSession session) {
        String loginname = request.getParameter("uname");
        //loginname为电话号码
        String loginpass = request.getParameter("upass");
        String code = request.getParameter("code");
       String msm = (session.getAttribute(loginname)).toString();
        // String msm ="123456"; //暂时使用123456验证
        log4.info("客户端注册api初始化---- 获取到用户注册信息" + loginname + " " + loginpass + " " + code);


        if (loginname != null && loginpass != null) {
            if (code.equals(msm)) {
                String findpass = loginService.findPass(loginname);
                /*   //  System.out.println(" 查询密码为+ +"+findpass);*/
                if (findpass != null) {
                    return "userfalse";
                } else {

                    Login login = new Login();
                    login.setL_user(loginname);
                    login.setL_pass(loginpass);
                    login.setL_rights("user");
                    //注册角色 为 普通用户
                    loginService.add(login);
                    //存储登录信息表

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int l_id = loginService.getl_id(loginname);
                    User user = new User();
                    user.setL_id(l_id);
                    userService.add(user);
                    //存储用户信息表

                    log4.info("用户注册成功");

                    return "registerok";
                }
            } else {
                return "smsfalse";
            }
        } else {
            return "false";
        }
    }

    /**
     * 注释短信api
     * /*  获取短信验证码api
     * 返回1为成功
     */
    @ResponseBody
    @RequestMapping(value = "jsondata/registersmsapi.do")
    public int registersmscontroller(HttpServletRequest request, HttpSession session) {

        /*      System.out.println("-registersmscontroller-" + phone);*/
        log4.info("短信验证码模块调用--------------------");
        String phone = request.getParameter("phone");
        AliyunSms sms = new AliyunSms();
        int p = phone.length();
        if (p == 11) {
            int smskey = Integer.parseInt(Random_pojo.getRandomString(6));
            //获取6位数随机验证码

            SendSmsResponse response = null;

            try {
                response = AliyunSms.sendSms(phone, smskey);
                log4.info("短信验证码已发送成功---------------" + smskey);
            } catch (ClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (response.getCode().equals("OK")) {
                    session.setAttribute(phone, smskey);
                    return 1;
                }else{
                    // return 0;
                    return 0;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }


    @ResponseBody
    @RequestMapping("jsondata/sendCodetoemail.do")
    public String sendEmail(Email email,HttpSession session) throws Exception {

        int smskey = Integer.parseInt(Random_pojo.getRandomString(6));


        if(email!=null){
            email.setSmskey(String.valueOf(smskey));
            //获取6位数随机验证码
            System.out.println("email:"+email.toString());
            SendMail.sendEmai(email);
            session.setAttribute("email", smskey);
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping("jsondata/forgetPass.do")
    public String findPass(String uname,String code,String upass,HttpSession session){
        String msmkey = (session.getAttribute("email")).toString();
        System.out.println(uname+" "+code+" "+upass);
        if(msmkey.equals(code)){
            upass=AppMD5Util.getMD5(upass);
           loginService.updatePass(uname,upass);
            return "ok";
        }else{
            return "codeerro";
        }
    }


    @ResponseBody
    @RequestMapping("jsondata/forgetPassBySms.do")
    public String findPassBySms(String uname,String code,String upass,HttpSession session){
        String msmkey = (session.getAttribute(uname)).toString();
        if(msmkey.equals(code)){
            upass=AppMD5Util.getMD5(upass);
            loginService.updatePass(uname,upass);
            return "ok";
        }else{
            return "codeerro";
        }
    }

    @ResponseBody
    @RequestMapping("/jsondata/getUserInfo.do")
    public User getUserInfo(String uid){
                if(uid!=null){
                  User user=  userService.getUserbyUid(Integer.parseInt(uid));
                  return user;
                }
                return null;
    }
}
