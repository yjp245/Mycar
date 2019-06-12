package cn.mycar.controller;

import cn.mycar.pojo.Category;
import cn.mycar.pojo.Login;
import cn.mycar.pojo.User;

import cn.mycar.service.CategoryService;
import cn.mycar.util.Page;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    /*查询全部*/
  /*  @RequestMapping("/listCategory")
    public ModelAndView listCategory(){
        ModelAndView mov=new ModelAndView();
        List<Category> list=categoryService.list();
        mov.addObject("list",list);
        mov.setViewName("listCate");
        return mov;
    }*/

    /*分页查询，方法2*/
    @RequestMapping("/listCategory")
    public ModelAndView listCategory(Page page) {
        ModelAndView mov = new ModelAndView();

        PageHelper.offsetPage(page.getStart(), 5);
        List<Category> list = categoryService.list();
        int total = categoryService.count();
        page.caculateLast(total);

        mov.addObject("list",list);//放入转发参数
        mov.setViewName("listPageCate"); //放入jsp路劲
        return mov;
    }


    /*插入数据*/
    @RequestMapping("/addCategory")
    public ModelAndView addCategory(Category category) {
        ModelAndView mov = new ModelAndView();
        categoryService.add(category);
        mov.setViewName("redirect:/listCategory");
        return mov;
    }

      @RequestMapping("login")
      public String loginview(){
        return  "login";
      }

   /* @ResponseBody
    @RequestMapping("/loginUser")
    public User login(HttpServletRequest request, HttpSession session){
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        System.out.println("服务端接收"+name+" "+pass);


        User user=new User();
        user.setName(name);
        user.setPass(pass);
        session.setAttribute("user",user);
        return user;
    }



    @RequestMapping("/login")
    @ResponseBody
    public User login3(User user){
      System.out.println("服务端接收到的user"+user.getName()+" "+user.getPass());
       User user1=new User();
       user1.setName("yjp");
       user1.setPass("123");
        return user1;
  }
*/
/*   @RequestMapping("login")
    public ModelAndView login(){
      ModelAndView mol=new ModelAndView();
      mol.setViewName("login");
      return mol;
    }*/

}
