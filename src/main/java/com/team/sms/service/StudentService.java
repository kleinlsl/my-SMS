package com.team.sms.service;

import com.team.sms.bean.LoginForm;
import com.team.sms.bean.Student;

import java.util.List;

/**
 * @project: my-sms
 * @description: 业务层-操控学生信息
 * @author: dell
 * @date: 2020/5/14 - 14:36
 * @version: 1.0
 * @website:
 */
public interface StudentService {

    // TODO: 2020/5/14  验证登录信息是否正确
    Student login(LoginForm loginForm);

    // TODO: 2020/5/14  根据班级与学生名获取指定或全部学生信息列表
    List<Student> selectList(Student student);

    // TODO: 2020/5/14  根据学号获取指定学生信息
    Student fingBySno(Student student);

    // TODO: 2020/5/14  添加班级信息
    int insert(Student student);

    // TODO: 2020/5/14  根据id修改指定学生信息
    int update(Student student);

    // TODO: 2020/5/14  根据id修改指定学生密码
    int updatePassowrd(Student student);

    // TODO: 2020/5/14  根据id删除指定学生信息
    int deleteById(Integer[] ids);
}
