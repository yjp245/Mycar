package cn.mycar.aspect;

import cn.mycar.pojo.Log;
import cn.mycar.pojo.Login;
import cn.mycar.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class AdminlogAspect {

    @Autowired
    LogService logService;

    /**
     * 修改个人信息
     * 方法
     */
    @Pointcut(value = "execution(* cn.mycar.controller.AdminController.saveinfo(..))")
    public void saveinfocell(){
    }

    /**
     * 添设管理员
     *
     * 切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.AdminController.addAdmin(..))")
    public void addadmincell(){
    }

    /**
     * 删除管理员
     * 的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.AdminController.deleteAdmin(..))")
    public void deleteadmincell(){
    }

    /**
     * 修改管理员
     * 信息操作  的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.AdminController.resetpass(..))")
    public void resetpasscell(){
    }

    /**
     * 删除用户信息操作的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.AdminController.deleteUser(..))")
    public void deleteUsercell(){
    }


    /**
     *  修改个人信息操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "saveinfocell()", argNames = "object", returning = "object")
    public void saveinfocell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("管理员修改个人信息");
            logService.add(log);
        }

    }

    /**
     *  添加管理员操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "addadmincell()", argNames = "object", returning = "object")
    public void addadmincell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("添加管理员");
            logService.add(log);
        }

    }

    /**
     *  修改管理员操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "resetpasscell()", argNames = "object", returning = "object")
    public void resetpasscell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("修改管理员密码");
            logService.add(log);
        }

    }

    /**
     *  删除管理员操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */

    @AfterReturning(value = "deleteadmincell()", argNames = "object", returning = "object")
    public void deleteadmincell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("删除管理员");
            logService.add(log);
        }

    }

    /**
     *  删除用户操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */

    @AfterReturning(value = "deleteUsercell()", argNames = "object", returning = "object")
    public void deleteUsercell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("删除用户");
            logService.add(log);
        }

    }


}
