package com.team.sms.service;

import com.team.sms.bean.Grade;

import java.util.List;

/**
 * @project: my-sms
 * @description: 业务层-操控年级信息
 * @author: dell
 * @date: 2020/5/14 - 14:34
 * @version: 1.0
 * @website:
 */
public interface GradeService {

    // TODO: 2020/5/14 根据年级名称查询指定/全部年级列表信息
    List<Grade> selectList(Grade gradename);

    // TODO: 2020/5/14 查询所有年级列表信息(用于在班级管理页面中获取年级信息)
    List<Grade> selectAll();

    // TODO: 2020/5/14 根据年级名称查询指定年级信息
    Grade findByName(String gradename);

    // TODO: 2020/5/14  添加年级信息
    int insert(Grade grade);

    // TODO: 2020/5/14 根据id修改指定年级信息
    int update(Grade grade);

    // TODO: 2020/5/14 根据id删除指定年级信息
    int deleteById(Integer[] ids);
}
