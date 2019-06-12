package cn.mycar.mapper;

import cn.mycar.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    public void add(Admin admin);

    public void delete(int l_id);

    public void update(Admin admin);

    /* 通过l_id 获取管理员信息*/
    public Admin getAdminbyLid(int l_id);

    /*  通过aid 获取用户信息*/
    public Admin getAdminbyAid(int aid);

    /*获取用户信息表*/
    public List<Admin> list();


}
