package cn.mycar.service.impl;

import cn.mycar.mapper.LoginMapper;
import cn.mycar.pojo.Login;
import cn.mycar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl  implements LoginService {


    @Autowired
    LoginMapper loginMapper;

    @Override
    public Login getByL_id(int l_id) {
        return loginMapper.getByL_id(l_id);
    }

    @Override
    public void updatePass(String uname, String upass) {
        loginMapper.updatePass(uname,upass);
    }

    @Override
    public List<Login> list_rights(String rights) {
        return loginMapper.list_rights(rights);
    }
    public void add(Login login) {
        loginMapper.add(login);
    }

    
    public void delete(Login login) {
     loginMapper.delete(login.getL_id());
    }

    
    public void update(Login login) {
    loginMapper.update(login);
    }

    
    public String findPass(String l_user) {
        return loginMapper.findPass(l_user);
    }

    
    public Login get(String l_user) {
        return loginMapper.get(l_user);
    }

    
    public List<Login> list() {
        return loginMapper.list();
    }

    
    public int count() {
        return loginMapper.count();
    }


    public int getl_id(String  l_user) {
        return loginMapper.getL_id(l_user);
    }
}
