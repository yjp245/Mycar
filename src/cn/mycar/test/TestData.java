/**
 * Author:   JP
 * Date:     2018/8/26 0026 13:40
 * Description: 分割数据
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.test;

import cn.mycar.pojo.DriverData;
import cn.mycar.service.DriverDataService;
import cn.mycar.service.impl.DriverDataServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分割数据〉
 *
 * @author JP
 * @create 2018/8/26 0026
 * @since 1.0.0
 */

public class TestData {
    public static  SqlSession session;
    public static void main(String[] args) {
         String str="Model_start#DFSMJP001#1#29#89#0.61#0.08#117.56547#26.192708#end";

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        DriverDataService driverDataService=(DriverDataService)context.getBean("driverdataservice");
        DriverData driverData=new DriverData();
        driverData.setDname("1233");
        driverData.setFindperson(Integer.parseInt("1"));

        driverDataService.addDriver(driverData);
        System.out.println(driverData.toString());


    }
}
