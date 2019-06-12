package cn.mycar.mapper;

import cn.mycar.pojo.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {

    /*1.增加用户登录账户*/
    public void add(Login login);

    /*2删除账户*/
    public void delete(int id);

    /*3修改账户*/
    public void update(Login login);

    /*4查询账户密码*/
    public String findPass(String l_user);

    /*5查询账户信息*/
    public Login get(String l_user);

    /*6查询所有账户*/
    public List<Login> list();

    /*7查询账户数量*/
    public int count();

    /*查询用户 l_id*/
    public int getL_id(String l_user);


    public Login getByL_id(int l_id);



    public List<Login> list_rights(String rights);

    public void updatePass(@Param("uname") String uname, @Param("upass") String upass);

}
