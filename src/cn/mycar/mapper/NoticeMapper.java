package cn.mycar.mapper;

import cn.mycar.pojo.Notice;

import java.util.HashMap;
import java.util.List;

public interface NoticeMapper {


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
    public int delete(Integer nid);
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
