/**
 * Author:   JP
 * Date:     2018/12/1 0001 10:24
 * Description: 操作日志控制器
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Feedback;
import cn.mycar.pojo.Log;
import cn.mycar.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈操作日志控制器〉
 *
 * @author JP
 * @create 2018/12/1 0001
 * @since 1.0.0
 */

@Controller
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("loglist.do")
    public ModelAndView adminloglist(){
        ModelAndView model=new ModelAndView();

        List<Log> List=logService.list();
        model.addObject("list",List);
        model.setViewName("adminlog-list");
        return model;
    }

    @ResponseBody
    @RequestMapping("deletelog.do")
    public String deletelog(String id){
          if(id !=null){
              int idd=Integer.parseInt(id);
              logService.delete(idd);
                return "ok";
          }
          return "erro";
    }

}
