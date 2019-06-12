package cn.mycar.service.impl;

import cn.mycar.mapper.UserMapper;
import cn.mycar.pojo.User;
import cn.mycar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delete(User user) {
    userMapper.delete(user.getUid());
    }

    @Override
    public void update(User user) {
       userMapper.update(user);
    }

    @Override
    public User getUserbyLid(int l_id) {
        return userMapper.getUserbyLid(l_id);
    }

    @Override
    public User getUserbyUid(int uid) {
        return userMapper.getUserbyUid(uid);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
