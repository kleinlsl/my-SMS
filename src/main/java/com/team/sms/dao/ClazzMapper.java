package com.team.sms.dao;

import com.team.sms.bean.Clazz;

import java.util.List;

/**
 * @project: my-sms
 * @description: 数据访问层--操控班级信息
 * @author: dell
 * @date: 2020/5/11 - 20:31
 * @version: 1.0
 * @website:
 */
public interface ClazzMapper {

    /**
     * @description: 根据班级名称获取指定/全部班级信息列表
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
    List<Clazz> selectList(Clazz clazz);

    /**
     * @description: 查询所有班级列表信息(用于在学生管理页面中获取班级信息)
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
    List<Clazz> selectAll();

    /**
     * @description: 获取指定名称的班级信息
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
    Clazz findByName(String name);

    /**
     * @description: 添加班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
    int insert(Clazz clazz);

    /**
     * @description: 根据id删除指定班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
    int deleteById(Integer[] ids);

    /**
     * @description: 根据id修改指定班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
    int update(Clazz clazz);
}
