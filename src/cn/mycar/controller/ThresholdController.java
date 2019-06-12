package cn.mycar.controller;

import cn.mycar.json.SingleObject;
import cn.mycar.json.StatusCode;
import cn.mycar.pojo.Threshold;
import cn.mycar.service.ThresholdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author JP
 * @title: ThresholdController
 * @projectName mycar
 * @description:阈值设置控制器
 * @date 2019/4/18 0018
 */

@Controller
@RequestMapping("")
public class ThresholdController {

    @Autowired
    ThresholdService    thresholdService;




    /**
     * 修改阈值配置
     * @param threshold
     * @return
     */
    @ResponseBody
    @RequestMapping("jsondata/updateOrAddThreshold.do")
    public SingleObject updateThreshold(Threshold threshold, HttpSession session){
       Threshold threshold1= thresholdService.selectByDnum(threshold.getDnum());
        SingleObject result=new SingleObject();
       if(threshold1!=null){
           int n= thresholdService.updateThreshold(threshold);
           if(n>0){
               result.setMsg("修改成功");
               result.setCode(StatusCode.CODE_SUCCESS);
               return result;
           }
       }
         int id=(Integer) session.getAttribute("loginUserUid");
         threshold.setUid(id);
        int t= thresholdService.add(threshold);
        if(t>0){
            result.setMsg("配置成功");
            result.setCode(StatusCode.CODE_SUCCESS);
            return result;
        }
        result.setMsg("配置失败");
        result.setCode(StatusCode.CODE_ERROR);
        return result;
    }


    @ResponseBody
    @RequestMapping("/jsondata/getThreshold.do")
    public Threshold getThreshold(String dnum){
        Threshold threshold1= thresholdService.selectByDnum(dnum);
        if(threshold1!=null){
            return  threshold1;
        }
        return null;
    }

}
