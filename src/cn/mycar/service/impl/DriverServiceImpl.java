/**
 * Author:   JP
 * Date:     2018/9/18 0018 19:30
 * Description: 设备业务实现
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.DriverMapper;
import cn.mycar.pojo.Driver;
import cn.mycar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备业务实现〉
 *
 * @author JP
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
@Component("driverservice")
public class DriverServiceImpl  implements DriverService {

    @Autowired
    DriverMapper driverMapper;
    @Override
    public void add(Driver driver) {
           driverMapper.add(driver);
    }

    @Override
    public void delete(int did) {
          driverMapper.delete(did);
    }

    @Override
    public void update(Driver driver) {
       driverMapper.update(driver);
    }

    @Override
    public List<Driver> list(int uid) {
        return driverMapper.list(uid);
    }

    @Override
    public Driver findDriver(String dnum) {
        return driverMapper.findDriver(dnum);
    }

    @Override
    public Driver findDriverByDid(int did) {
        return driverMapper.findDriverByDid(did);
    }

}
