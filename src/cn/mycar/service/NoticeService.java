/**
 * Author:   JP
 * Date:     2018/12/2 0002 12:44
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service;

import cn.mycar.pojo.Notice;

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

public interface NoticeService {

    /**
     * @Author jp
     * @Description //TODO 添加公告
     * @Date 11:25 2019/4/18 0018
     * @Param
     * @return
     **/
    public  int add(Notice notice);


    /**
     * 删除公告
     * @param id
     * @return
     */
    public int delete(int nid);
    /**
     * @Author jp
     * @Description //TODO 公告列表
     * @Date 11:25 2019/4/18 0018
     * @Param
     * @return
     **/


    /**
     * 修改公告
     * @param project
     */
    public int update(Notice project);





    /**
     * 查询公告
     * @param nid
     * @return
     */
    public Notice select(int nid);


    /**
     * 查询列表
     * @return
     */
    public List<HashMap> list();



}
