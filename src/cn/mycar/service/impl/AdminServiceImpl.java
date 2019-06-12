package cn.mycar.service.impl;

import cn.mycar.mapper.AdminMapper;
import cn.mycar.pojo.Admin;
import cn.mycar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public void add(Admin admin) {
               adminMapper.add(admin);
    }

    @Override
    public void delete(int l_id) {
          adminMapper.delete(l_id);
    }

    @Override
    public void update(Admin admin) {
          adminMapper.update(admin);
    }

    @Override
    public Admin getAdminbyLid(int l_id) {
        return adminMapper.getAdminbyLid(l_id);
    }

    @Override
    public Admin getAdminbyAid(int aid) {
        return adminMapper.getAdminbyAid(aid);
    }

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }
}
