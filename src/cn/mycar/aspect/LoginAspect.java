/**
 * Author:   JP
 * Date:     2018/11/24 0024 18:28
 * Description: 用户操作日志
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.aspect;

import cn.mycar.mapper.LogMapper;
import cn.mycar.pojo.Log;
import cn.mycar.pojo.Login;
import cn.mycar.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录操作日志〉
 *
 * @author JP
 * @create 2018/11/24 0024
 * @since 1.0.0
 */

@Aspect
@Component
public class LoginAspect {

    @Autowired
    LogService logService;


    /**
     * 账户登录方法的切入点
     */
     @Pointcut(value = "execution(* cn.mycar.controller.ViewController.main*(..))")
     public void logincell(){
         }

    /**
     *  登录操作(后置通知)
     * @param joinpoint
     * @throws Throwable
     *    @After(value = "execution(* cn.mycar.controller.ViewController.main*(..))")
     */
    @AfterReturning(value = "logincell()", argNames = "object", returning = "object")
    public void login(JoinPoint joinPoint,Object object) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //读取session中的用户

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("login_pojo");
        if(user !=null){
            Log log=new Log();
            log.setUser(user.getL_user());
            log.setRole(user.getL_rights());
            log.setContent("登录系统");
            logService.add(log);
        }

    }




}
