package com.team.sms.service.impl;

import com.team.sms.bean.Admin;
import com.team.sms.bean.LoginForm;
import com.team.sms.dao.AdminMapper;
import com.team.sms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: my-sms
 * @description: 业务层实现类-操控管理员信息
 * @author: dell
 * @date: 2020/5/14 - 14:42
 * @version: 1.0
 * @website:
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    //注入Mapper接口对象
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(LoginForm loginForm) { return adminMapper.login(loginForm); }

    @Override
    public List<Admin> selectList(Admin admin) {
        return adminMapper.selectList(admin);
    }

    @Override
    public Admin findByName(String name) {
        return adminMapper.findByName(name);
    }

    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int update(Admin admin) { return adminMapper.update(admin); }

    @Override
    public int updatePassowrd(Admin admin) {
        return adminMapper.updatePassword(admin);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return adminMapper.deleteById(ids);
    }

}
