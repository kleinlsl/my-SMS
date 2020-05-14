package com.team.sms.service.impl;

import com.team.sms.bean.Grade;
import com.team.sms.dao.GradeMapper;
import com.team.sms.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: my-sms
 * @description: 业务层实现类-操控年级信息
 * @author: dell
 * @date: 2020/5/14 - 14:48
 * @version: 1.0
 * @website:
 */

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    //注入Mapper接口对象
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> selectList(Grade gradename) {
        return gradeMapper.selectList(gradename);
    }

    @Override
    public List<Grade> selectAll() {
        return gradeMapper.selectAll();
    }

    @Override
    public Grade findByName(String gradename) {
        return gradeMapper.findByName(gradename);
    }

    @Override
    public int insert(Grade grade) {
        return gradeMapper.insert(grade);
    }

    @Override
    public int update(Grade grade) {
        return gradeMapper.update(grade);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return gradeMapper.deleteById(ids);
    }

}
