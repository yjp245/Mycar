/**
 * Author:   JP
 * Date:     2018/12/1 0001 15:33
 * Description: 项目介绍
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.mapper.ProjectMapper;
import cn.mycar.pojo.Project;
import cn.mycar.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈项目介绍〉
 *
 * @author JP
 * @create 2018/12/1 0001
 * @since 1.0.0
 */

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @ResponseBody
    @RequestMapping("toproject.do")
    public Project  toview(){

        Project project=projectService.select();
        return project;
    }

    @ResponseBody
    @RequestMapping("updateProject.do")
    public String updateproject(Project project){
        System.out.println(project.toString());

                 projectService.update(project);
                 return "ok";

    }
}
