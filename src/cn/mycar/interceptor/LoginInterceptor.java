/**
 * Author:   JP
 * Date:     2018/8/23 0023 17:18
 * Description: 登录验证拦截器
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.interceptor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录验证拦截器〉
 *
 * @author JP
 * @create 2018/8/23 0023
 * @since 1.0.0
 */

import cn.mycar.pojo.Log4;
import cn.mycar.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC的拦截器HandlerInterceptorAdapter对应提供了
 * 三个preHandle，postHandle，afterCompletion方法。
 * <p>
 * preHandle在业务处理器处理请求之前被调用;
 * postHandle在业务处理器处理请求执行完成后,生成视图之前执行;
 * afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 。
 *
 * @author JP
 */
public class LoginInterceptor  implements HandlerInterceptor {

    Log4 log4 = new Log4(this.getClass());

    private  static final String[] IGNORE_URI= {"user/login.do","login","jsondata",".mp4",".mp3"};
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
      //  System.out.println("AuthorizationInterceptor preHandle -->账户拦截器 ");

        //flag变量用于判断用户是否登录，默认为false
        boolean flag =false;
        //获取请求的路劲进行判断

        String servletPath=request.getServletPath();
        //判断请求是否拦截
        for(String s:IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            //1.获取session中的用户
            //使用Object可以接受 admin类 和User类
            Object user=(Object) request.getSession().getAttribute("loginUserInfo");
            //2.判断用户是否登录
            if(user==null){
                //如果用户没有登录，则设置提示信息，跳转到登录界面
                request.setAttribute("loginerro", "请先登录再访问网站");

                try {
                   // System.out.println("AuthorizationInterceptor 不存在用户session 被拦截：");
                    request.getRequestDispatcher("login.do").forward(request,response);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
              //  System.out.println("AuthorizationInterceptor 拦截放行：");
                flag=true;
            }
        }

        return flag;
    }


}
