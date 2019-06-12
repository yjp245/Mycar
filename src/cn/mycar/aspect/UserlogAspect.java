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


/**
 * 〈一句话功能简述〉<br>
 * 〈用户操作日志〉
 *
 * @author JP
 * @create 2018/11/24 0024
 * @since 1.0.0
 */
@Aspect
@Component
public class UserlogAspect {
    @Autowired
LogService logService;

    /**
     * 用户修改方法的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.service.UserService.update(..))")
    public void updatecell(){
    }

    /**
     * 添加设备的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.DriverController.add_device(..))")
    public void adddevicecell(){
    }

    /**
     * 删除设备的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.DriverController.delete_device(..))")
    public void deletedevicecell(){
    }

    /**
     * 修改设备的切入点
     */
    @Pointcut(value = "execution(* cn.mycar.controller.DriverController.device_update(..))")
    public void updatedevicecell(){
    }


    /**
     *  信息修改操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "updatecell()", argNames = "object", returning = "object")
    public void updatecell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("修改信息");
            logService.add(log);
        }

    }

    /**
     *  添加设备操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "adddevicecell()", argNames = "object", returning = "object")
    public void adddevicecell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("添加设备");
            logService.add(log);
        }

    }

    /**
     *  修改设备操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */
    @AfterReturning(value = "updatedevicecell()", argNames = "object", returning = "object")
    public void updatedevicecell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("修改设备信息");
            logService.add(log);
        }

    }

    /**
     *  删除设备操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *
     */

    @AfterReturning(value = "deletedevicecell()", argNames = "object", returning = "object")
    public void deletedevicecell(JoinPoint joinPoint, Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){

            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("删除设备");
            logService.add(log);
        }

    }

}
