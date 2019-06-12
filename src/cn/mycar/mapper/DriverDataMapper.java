package cn.mycar.mapper;


import cn.mycar.pojo.DriverData;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈设备表 映射〉
 *
 * @author JP
 * @create 2018/8/23 0023
 * @since 1.0.0
 */
public interface DriverDataMapper {

    public void addDriver(DriverData driver);
    //添加设备

    public void deleteDriverByDataID(int dataid);
    // 通过dataid 删除设备

    public void deleteDriverByDname(String dname);
    // 通过did 删除设备


    public List<DriverData> listAll(String dname);
    //根据设备ID查询所有信息

   public List<DriverData> list();


    /**
     * 查询设备近20条数据
     * @param dname
     * @return
     */
   public List<DriverData> listfor20(String dname);

   
   public DriverData selectnewdata(String dname);

}
