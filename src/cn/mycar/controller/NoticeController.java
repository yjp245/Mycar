/**
 * Author:   JP
 * Date:     2018/12/2 0002 13:43
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Admin;
import cn.mycar.pojo.Notice;
import cn.mycar.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/12/2 0002
 * @since 1.0.0
 */

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * 公告列表
     * @param model
     * @return
     */
    @RequestMapping("/toNoticelist.do")
   public String toNoticeView(Model model){
        List<HashMap> list=noticeService.list();
        model.addAttribute("list",list);
        return  "notice-list";
   }


    /**
     * 公告列表
     * @param model
     * @return
     */
    @RequestMapping("/toNoticelist2.do")
    public String toNoticeView2(Model model){
        List<HashMap> list=noticeService.list();
        model.addAttribute("list",list);
        return  "notice-list2";
    }
    /**
     * 删除公告
     * @param nid
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteNotice.do")
   public String delete(String nid){
        Integer nnid=Integer.parseInt(nid.trim());
         int n= noticeService.delete(nnid);
         if(n>0){
             return "ok";
         }
         return "erro";
   }


    /**
     * 发布公告
     * @param notice
     * @return
     */
   @ResponseBody
   @RequestMapping("addnotice.do")
   public String addNotice(Notice notice, HttpSession session){
        if (notice!=null){
        Admin admin=(Admin) session.getAttribute("loginUserInfo");
         notice.setUid(admin.getAid());
         int n=   noticeService.add(notice);
         if(n>0){
             return "ok";
            }
        }
        return "erro";
   }

}
