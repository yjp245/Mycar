/**
 * Author:   JP
 * Date:     2018/10/10 0010 12:58
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Feedback;
import cn.mycar.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/10/10 0010
 * @since 1.0.0
 */

@Controller
@RequestMapping("")
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;


    @ResponseBody
    @RequestMapping("jsondata/sendFeedBack.do")
    public String sendFeedBack(HttpServletRequest request){

        String  probelm =request.getParameter("probelm");
        String phone= request.getParameter("phone");
        if(probelm !=null && phone !=null){
            Feedback feedback=new Feedback();
            feedback.setProbelm(probelm);
            feedback.setPhone(phone);
             feedBackService.add(feedback);
            return "ok";
        }
         return "false";
    }

    @RequestMapping("feedback-list.do")
    public ModelAndView showfeedbackList(){
        ModelAndView model=new ModelAndView();

        List<Feedback> List=feedBackService.list();
        model.addObject("list",List);
        model.setViewName("feedback-list");
        return model;
    }

}
