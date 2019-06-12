package cn.mycar.mapper;

import cn.mycar.pojo.User;

import java.util.List;

public interface UserMapper {

    public void add(User user);

    public void delete(int uid);

    public void update(User user);

    /* 通过l_id 获取用户信息*/
    public User getUserbyLid(int l_id);

    /*  通过uid 获取用户信息*/
    public User getUserbyUid(int uid);

    /*获取用户信息表*/
    public List<User> list();


}
