/**
 * Author:   JP
 * Date:     2018/9/22 0022 19:54
 * Description: 设备图表数据
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Driver;
import cn.mycar.pojo.DriverData;
import cn.mycar.service.DriverDataService;
import cn.mycar.service.DriverService;
import cn.mycar.udpserver.MyServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备图表数据〉
 *
 * @author JP
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
@Controller
@RequestMapping("")
public class ChartDriverController {


    @Autowired
    DriverDataService driverDataService;

    @Autowired
    DriverService driverService;



    @RequestMapping("/Tochar_data.do")
    public ModelAndView update_driver(String dnum) {
        ModelAndView mov = new ModelAndView();
        /**
         * 通过did获取设备信息
         */

        mov.addObject("device_info", dnum);
        mov.setViewName("chart_data");
        return mov;
    }

    /**
     * 查看设备实时图表数据
     */
    @RequestMapping("jsondata/chart_data.do")
    @ResponseBody
    public DriverData getHisDates(HttpServletRequest request, String dnum) {

        ServletContext context = MyServletContextListener.servletContext();
        DriverData driverData = (DriverData) context.getAttribute("nowDriverdata");
        if (driverData != null) {
            if(driverData.getDname().equals(dnum)){
                // System.out.println("最新的一条数据=" + driverData.toString());
                return driverData;
            }

            return null;
        }

        return null;
    }

}
