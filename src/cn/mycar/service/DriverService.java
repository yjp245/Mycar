/**
 * Author:   JP
 * Date:     2018/9/18 0018 19:24
 * Description: 设备业务：增删改查
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service;

import cn.mycar.pojo.Driver;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备业务：增删改查〉
 *
 * @author JP
 * @create 2018/9/18 0018
 * @since 1.0.0
 */

public interface DriverService {

    public void add(Driver driver);
    //添加设备

    public void delete(int did);
    // 通过did 删除设备

    public void update(Driver driver);
    // 修改用户设备

    public List<Driver> list(int uid);
    //查询用户所有设备

    public Driver findDriver(String dnum);
    //通过设备编号查询设备

    public Driver findDriverByDid(int dnum);
    //通过设备ID查询设备
}
