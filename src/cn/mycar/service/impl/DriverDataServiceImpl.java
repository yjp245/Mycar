/**
 * Author:   JP
 * Date:     2018/9/4 0004 14:45
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.DriverDataMapper;
import cn.mycar.pojo.DriverData;
import cn.mycar.service.DriverDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/9/4 0004
 * @since 1.0.0
 */

@Component("driverdataservice")
public class DriverDataServiceImpl implements DriverDataService {


    @Autowired
    DriverDataMapper driverDataMapper;

    @Override
    public void addDriver(DriverData driver) {
         driverDataMapper.addDriver(driver);
    }

    @Override
    public void deleteDriverByDataID(int dataid) {
      driverDataMapper.deleteDriverByDataID(dataid);
    }

    @Override
    public void deleteDriverByDname(String dname) {
       driverDataMapper.deleteDriverByDname(dname);
    }

    @Override
    public List<DriverData> listAll(String dname) {
        return driverDataMapper.listAll(dname);
    }

    @Override
    public List<DriverData> list(){
       return driverDataMapper.list();
    }

	@Override
	public DriverData selectnewdata(String dname) {
		// TODO Auto-generated method stub
		return driverDataMapper.selectnewdata(dname);
	}

    @Override
    public List<DriverData> listfor20(String dname) {
        return driverDataMapper.listfor20(dname);
    }
}
