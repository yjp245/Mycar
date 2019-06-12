/**
 * Author:   JP
 * Date:     2018/9/18 0018 13:25
 * Description: 设备数据控制器
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.controller;

import cn.mycar.pojo.Driver;
import cn.mycar.pojo.DriverData;
import cn.mycar.pojo.User;
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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设备数据控制器〉
 *
 * @author JP
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
@Controller
@RequestMapping("")
public class DriverController {
    @Autowired
    DriverDataService driverDataService;

    @Autowired
    DriverService driverService;
    /**
     * 查看设备历史数据，后面做修改
     */
    @RequestMapping("/data-list.do")
    public ModelAndView listDriverData() {
        ModelAndView mov = new ModelAndView();
        List<DriverData> list = driverDataService.list();
        mov.addObject("list", list);
        mov.setViewName("data-list");
        return mov;
    }

    /**
     * 根据设备编号查询设备历史数据
     * dname
     * @return data-list
     */
    @RequestMapping("/findData-list.do")
    public ModelAndView findDriverData(String dname) {
        ModelAndView mov = new ModelAndView();
        List<DriverData> list = driverDataService.listAll(dname);
        mov.addObject("list", list);
        mov.setViewName("data-list");
        return mov;
    }

    /**
     * 查询设备近20条历史数据
     * @param dnum
     * @return
     */
    @ResponseBody
    @RequestMapping("jsondata/deviceData.do")
    public List<DriverData> Datas(String dnum){
        List<DriverData> list=null;
        if(dnum != null){
            list= driverDataService.listfor20(dnum);
        }
        return list;
    }
    
    
    
    /**
     * 查询该用户所有设备列表
     * @return
     */
 @RequestMapping("/driver-list.do")
 public ModelAndView driverlist(HttpSession session) {
     ModelAndView mov = new ModelAndView();
     User user= (User) session.getAttribute("loginUserInfo");
     ServletContext context = MyServletContextListener.servletContext();
     DriverData driverData = (DriverData) context.getAttribute("nowDriverdata");
     List<Driver> list=driverService.list(user.getUid());

     if(driverData!=null){
         for(Driver driver:list){
             if(driver.getDnum().equals(driverData.getDname())){
                 driver.setD_state("在线");
                 driverService.update(driver);
             }else {
                 driver.setD_state("离线");
                 driverService.update(driver);
             }
         }

     }else{
         for(Driver driver:list){
            driver.setD_state("离线");
            driverService.update(driver);
         }
     }
     mov.addObject("list", list);
     mov.setViewName("device-list");
     return mov;

 }

    @ResponseBody
    @RequestMapping("jsondata/device-list.do")
    public List<Driver> driverlist(String uid) {
     if(uid != null){
         int id=Integer.parseInt(uid);
        List<Driver> list= driverService.list(id);
         return list;
     }
        return null;
    }



    /**
     * 添加设备
     * @return
     */
    @ResponseBody
    @RequestMapping("jsondata/device-add.do")
    public String add_device(String uid,String dnum,String dname,String dpass,String beizhu) {
         int uid1=Integer.parseInt(uid);
        System.out.println(dnum+" "+dname+" "+dpass);
         if(dnum !=null && dname !=null && dpass !=null) {
        	 
        	   Driver driver1=driverService.findDriver(dnum);
        	      if(driver1!=null){
        	          return "addfalse";
        	      }
        	        Driver driver=new Driver();
        	        driver.setDnum(dnum);
        	        driver.setDname(dname);
        	        driver.setDpass(dpass);
        	        driver.setBeizhu(beizhu);
        	         driver.setD_bind(1);
        	         driver.setUid(uid1);
        	      driver.setD_state("离线");
        	      driverService.add(driver);
        	        return "ok";
         }
         else {
             return "nullerro";
         }
     
    }

    /**
     * 删除设备
     * @return删除设备
     */
   @ResponseBody
    @RequestMapping("jsondata/device_delete.do")
    public String delete_device(String did){
       System.out.println(did);
       Integer id=Integer.parseInt(did);
       driverService.delete(id);
       return "ok";
   }


    /**
     *跳转到修改设备信息界面
     * 传递设备相关信息
     * @param
     * @return
     */

    @RequestMapping("/To_device-update.do")
    public ModelAndView update_driver(Driver driver) {
        ModelAndView mov = new ModelAndView();
        /**
         * 通过did获取设备信息
         */
      Driver driver1= driverService.findDriverByDid(driver.getDid());
      mov.addObject("device_info", driver1);
     //   System.out.println(driver1.toString());
        mov.setViewName("device-update");
        return mov;
    }

    @ResponseBody
    @RequestMapping("jsondata/device-get.do")
    public Driver update_device(String did) {
       // System.out.println(driver.toString());
        int id=Integer.parseInt(did);
        if(did!=null){
            Driver driver1= driverService.findDriverByDid(id);
            return driver1;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("jsondata/device-update.do")
    public String update_device(Driver driver) {
        System.out.println(driver.toString());
        if(driver!=null){
            driverService.update(driver);
            return "ok";
        }
       return "null";
    }


    /**
     *
     *   传递设备相关信息
     * @param
     * @return
     */
    /*@ResponseBody
    @RequestMapping("jsondata/driverdata-api.do")
    public DriverData DriverdataApi(HttpServletRequest request) {
         String dname=request.getParameter("dname");
         if(dname!= null){
             List<DriverData> list = driverDataService.listAll(dname);
             int size=list.size();
             if(size!=0){
                 DriverData driverData=list.get(size-1);
                 return driverData;
             }
             return null;
         }
         return null;
    }*/


    @ResponseBody
    @RequestMapping("jsondata/driverdata-api.do")
    public DriverData DriverdataApi(HttpServletRequest request) {
         String dname=request.getParameter("dname");
         if(dname!= null){
           
                 DriverData driverData=driverDataService.selectnewdata(dname);
                 return driverData;
           
         }
         return null;
    }


}
