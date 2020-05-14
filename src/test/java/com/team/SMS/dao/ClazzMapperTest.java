package com.team.SMS.dao;


import com.team.SMS.bean.Clazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @project: my-SMS
 * @description:
 * @author: dell
 * @date: 2020/5/12 - 12:35
 * @version: 1.0
 * @website:
 */
public class ClazzMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private ClazzMapper clazzMapper;

    @Before
    public void init(){
        // 读取mybatis配置文件
        String resource = "mybatis-conf/mybatis-config.xml";
        InputStream inputStream;
        try {
            // 得到配置文件流
            inputStream = Resources.getResourceAsStream(resource);
            // 根据配置文件信息，创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 获得Mapper接口的代理对象
            clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        }

    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * @description: 根据班级名称获取指定/全部班级信息列表
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
//    List<Clazz> selectList(Clazz clazz);
    @Test
    public void selectList(){

    }

    /**
     * @description: 查询所有班级列表信息(用于在学生管理页面中获取班级信息)
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
//    List<Clazz> selectAll();
    @Test
    public void selectAll(){

    }

    /**
     * @description: 获取指定名称的班级信息
     * @param:
     * @date: 2020/5/11 - 20:32
     * @return:
     */
//    Clazz findByName(String name);
    @Test
    public void findByName(){

    }

    /**
     * @description: 添加班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
//    int insert(Clazz clazz);
    @Test
    public void insert(){
        Clazz clazz=new Clazz("计算机科学与技术2班","2017级");
        int res=clazzMapper.insert(clazz);
        Assert.assertTrue(res>0);
    }

    /**
     * @description: 根据id删除指定班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
//    int deleteById(Integer[] ids);
    @Test
    public void deleteById(){

    }

    /**
     * @description: 根据id修改指定班级信息
     * @param:
     * @date: 2020/5/11 - 20:33
     * @return:
     */
//    int update(Clazz clazz);
    @Test
    public void update(){

    }

}