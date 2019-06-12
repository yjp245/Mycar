/**
 * Author:   JP
 * Date:     2018/9/4 0004 14:24
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service;

import cn.mycar.pojo.DriverData;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/9/4 0004
 * @since 1.0.0
 */

public interface DriverDataService {

    public void addDriver(DriverData driver);
    //添加设备

    public void deleteDriverByDataID(int dataid);
    // 通过dataid 删除设备

    public void deleteDriverByDname(String dname);
    // 通过did 删除设备


    public List<DriverData> listAll(String dname);
    //根据设备ID查询所有信息

    public List<DriverData> list();
    
    public DriverData selectnewdata(String dname);

    /**
     * 查询设备近20条数据
     * @param dname
     * @return
     */
    public List<DriverData> listfor20(String dname);

}
