/**
 * Author:   JP
 * Date:     2018/12/1 0001 23:05
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.ProjectMapper;
import cn.mycar.pojo.Project;
import cn.mycar.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/12/1 0001
 * @since 1.0.0
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void update(Project project) {
    projectMapper.update(project);
    }

    @Override
    public Project select() {
        return projectMapper.select();
    }
}
