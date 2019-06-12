/**
 * Author:   JP
 * Date:     2018/11/24 0024 21:34
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.mapper;

import cn.mycar.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/11/24 0024
 * @since 1.0.0
 */

public interface LogMapper {

    /**
     * 增加日志
     * @param log
     */
    public void add(Log log);

    /**
     * 删除日志
     * @param logid
     */
    public void delete(@Param("logid")int logid);


    /**
     * 查询所有日志
     * @return
     */
    public List<Log> list();


    /**
     * 通过角色等级查询日志
     * @return
     */
    public List<Log> listbyrole(String role);

    /**
     * 通过用户查询日志
     * @return
     */
   public List<Log> listbyuser(String user);

}
