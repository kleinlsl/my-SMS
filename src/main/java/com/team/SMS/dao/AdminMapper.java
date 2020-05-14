package com.team.SMS.dao;

import com.team.SMS.bean.Admin;
import com.team.SMS.bean.LoginForm;

import java.util.List;

/**
 * @project: my-SMS
 * @description: 数据访问层--操控管理员信息
 * @author: dell
 * @date: 2020/5/11 - 20:22
 * @version: 1.0
 * @website:
 */
public interface AdminMapper {
    /**
     * @description: 验证登录信息是否正确
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    Admin login(LoginForm loginForm);

    /**
     * @description: 通过姓名查询指定管理员信息
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    Admin findByName(String name);

    /**
     * @description: 添加管理员信息
     * @param:
     * @date: 2020/5/11 - 20:24
     * @return:
     */
    int insert(Admin admin);

    /**
     * @description: 根据姓名模糊查询指定|所有管理员信息 列表
     * @param:
     * @date: 2020/5/11 - 20:25
     * @return:
     */
    List<Admin> selectList(Admin admin);

    /**
     * @description: 根据id更新指定管理员信息列表 ： 密码除外
     * @param:
     * @date: 2020/5/11 - 20:26
     * @return:
     */
    int update(Admin admin);

    /**
     * @description: 根据id修改指定管理员密码
     * @param:
     * @date: 2020/5/11 - 20:27
     * @return:
     */
    int updatePassword(Admin admin);

    /**
     * @description:  根据id删除指定管理员信息
     * @param:
     * @date: 2020/5/11 - 20:29
     * @return:
     */
    int deleteById(Integer[] ids);
}
