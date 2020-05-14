package com.team.SMS.service.impl;

import com.team.SMS.bean.Clazz;
import com.team.SMS.dao.ClazzMapper;
import com.team.SMS.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: my-SMS
 * @description: 业务层实现类-操控班级信息
 * @author: dell
 * @date: 2020/5/14 - 14:45
 * @version: 1.0
 * @website:
 */

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    //注入Mapper接口对象
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> selectList(Clazz clazz) { return clazzMapper.selectList(clazz); }

    @Override
    public List<Clazz> selectAll() {
        return clazzMapper.selectAll();
    }

    @Override
    public Clazz findByName(String name) {
        return clazzMapper.findByName(name);
    }

    @Override
    public int insert(Clazz clazz) {
        return clazzMapper.insert(clazz);
    }

    @Override
    public int update(Clazz clazz) {
        return clazzMapper.update(clazz);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return clazzMapper.deleteById(ids);
    }

}
