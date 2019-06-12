package cn.mycar.service;

import cn.mycar.pojo.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginService {

    /*1.增加用户登录账户*/
    public void add(Login login);

    /*2删除账户*/
    public void delete(Login login);

    /*3修改账户*/
    public void update(Login login);

    /*4查询账户密码*/
    public String findPass(String l_user);

    /**
     * 查询账户信息
     * @param l_user
     * @return
     */
    public Login get(String l_user);


    /*6查询所有账户*/
    public List<Login> list();

    /*7查询账户数量*/
    public int count();

    public int getl_id(String l_user);


    public List<Login> list_rights(String rights);

    public Login getByL_id(int l_id);

    public void updatePass(@Param("uname") String uname, @Param("upass") String upass);
}
