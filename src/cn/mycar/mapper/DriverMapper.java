package cn.mycar.mapper;


import cn.mycar.pojo.Driver;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈设备表 映射〉
 *
 * @author JP
 * @create 2018/8/23 0023
 * @since 1.0.0
 */
public interface DriverMapper {

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

    public Driver findDriverByDid(int did);
    //通过设备编号查询设备

}
