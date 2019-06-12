/**
 * Author:   JP
 * Date:     2018/10/14 0014 21:52
 * Description: 管理员控制器
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Admin;
import cn.mycar.pojo.Login;
import cn.mycar.pojo.User;
import cn.mycar.service.AdminService;
import cn.mycar.service.LoginService;
import cn.mycar.service.UserService;
import cn.mycar.util.AppMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理员控制器〉
 *
 * @author JP
 * @create 2018/10/14 0014
 * @since 1.0.0
 */
@Controller
@RequestMapping("")
public class AdminController {


    @Autowired
    LoginService loginService;

    @Autowired
    AdminService adminService;


   @Autowired
   UserService userService;
    /**
     * 获取管理员列表
     */
    @RequestMapping("admin-list.do")
    public ModelAndView showadminlist(){
        ModelAndView mov = new ModelAndView();

        List<Login> list=loginService.list_rights("admin");
        for(int i=0;i<list.size();i++){
            list.get(i).setL_id(i+1);
        }

        mov.addObject("list",list);
        mov.setViewName("admin-list");
        return mov;
    }

    @ResponseBody
    @RequestMapping("admin-add.do")
    public String addAdmin(HttpServletRequest request){
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");

        Login login=new Login();
        login.setL_user(user);
        login.setL_pass(AppMD5Util.getMD5(pass));
        login.setL_rights("admin");
        login.setL_state("off-line");
        //
        String findpass = loginService.findPass(user);
        if(findpass!=null){
            return "false";
        }
        loginService.add(login);
        Login login1=loginService.get(user);
        Admin admin=new Admin();
        admin.setAname(name);
        admin.setAphone(phone);
        admin.setL_id(login1.getL_id());
        adminService.add(admin);

        return "ok";
    }

       @RequestMapping("toAdmin_update.do")
    public ModelAndView toAdmin_update(Login login){

        ModelAndView model=new ModelAndView();
        if(login.getL_user()!=null){
            Login login1=loginService.get(login.getL_user());
            Admin admin= adminService.getAdminbyLid(login1.getL_id());
            model.addObject("login",login1);
            model.addObject("admin",admin);
          //  System.out.println(login1.toString()+" "+admin.toString());
        }
           model.setViewName("admin-update");
           return model;
    }

    @ResponseBody
    @RequestMapping("ResetPass.do")
    public String resetpass(HttpServletRequest request){

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        if(user !=null && pass !=null){
            pass=AppMD5Util.getMD5(pass);
            System.out.println(" "+pass+" "+user);
          Login login=loginService.get(user);
           login.setL_pass(pass);
           loginService.update(login);
            return "ok";
        }
   return "false";
    }


    @ResponseBody
    @RequestMapping("/DeleteAdmin.do")
   public String deleteAdmin(HttpServletRequest request){
        String user=request.getParameter("user");
        System.out.println(user);
         if(user!=null){
               Login login1=loginService.get(user);
             //System.out.println(login1.toString());

                 loginService.delete(login1);
                 adminService.delete(login1.getL_id());
                 return "ok";

         }
        return "false";
    }



    @RequestMapping("ToUser-list.do")
    public ModelAndView toUserlist(){
        ModelAndView mov = new ModelAndView();

        List<Login> list=loginService.list_rights("user");
        for(int i=0;i<list.size();i++){
            list.get(i).setL_id(i+1);
        }

        mov.addObject("list",list);
        mov.setViewName("user-list");
        return mov;
    }


    @RequestMapping("toUser_update.do")
    public ModelAndView toUser_update(Login login){

        ModelAndView model=new ModelAndView();
        if(login.getL_user()!=null){
            Login login1=loginService.get(login.getL_user());

            User user=userService.getUserbyLid(login1.getL_id());

            model.addObject("login",login1);
            model.addObject("user",user);
             // System.out.println(login1.toString()+" "+user.toString());
        }
        model.setViewName("user-update");
        return model;
    }

    @ResponseBody
    @RequestMapping("DeleteUser.do")
    public String deleteUser(HttpServletRequest request){
        String user=request.getParameter("user");
        if(user!=null){
            Login login1=loginService.get(user);
            User user1=userService.getUserbyLid(login1.getL_id());
            loginService.delete(login1);
            userService.delete(user1);
            return "ok";
        }
        return "false";
    }


    @RequestMapping("adminselfinfo.do")
    public ModelAndView admininfo(HttpSession session){
        ModelAndView model=new ModelAndView();

        model.setViewName("adminselfinfo");
        return model;
    }

    @ResponseBody
    @RequestMapping("Saveadmininfo.do")
    public String saveinfo(HttpServletRequest request,HttpSession session){

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        if(user !=null && pass !=null){
            pass=AppMD5Util.getMD5(pass);
            System.out.println(" "+pass+" "+user);
            Login login=loginService.get(user);
            login.setL_pass(pass);
            Admin admin=(Admin)session.getAttribute("loginUserInfo");
            admin.setAphone(phone);
            admin.setAname(name);
            loginService.update(login);
            adminService.update(admin);
            return "ok";
        }
        return "false";
    }

}
