package com.team.sms.service;

import com.team.sms.bean.Clazz;

import java.util.List;

/**
 * @project: my-sms
 * @description: 业务层-操控班级信息
 * @author: dell
 * @date: 2020/5/14 - 14:28
 * @version: 1.0
 * @website:
 */
public interface ClazzService {

    // TODO: 2020/5/14  根据年级与班级名查询指定/全部班级信息列表
    List<Clazz> selectList(Clazz clazz);

    // TODO: 2020/5/14   查询所有班级信息列表(用于在学生管理页面中获取班级信息)
    List<Clazz> selectAll();

    // TODO: 2020/5/14  添加班级信息
    int insert(Clazz clazz);

    // TODO: 2020/5/14   根据id删除指定班级信息
    int deleteById(Integer[] ids);

    // TODO: 2020/5/14   根据班级名获取指定班级信息
    Clazz findByName(String name);

    // TODO: 2020/5/14   根据id修改指定班级信息
    int update(Clazz clazz);
}
