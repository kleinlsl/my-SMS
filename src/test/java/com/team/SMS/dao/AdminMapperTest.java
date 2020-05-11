package com.team.SMS.dao;

import com.team.SMS.bean.Admin;
import com.team.SMS.bean.LoginForm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @project: my-SMS
 * @description:
 * @author: dell
 * @date: 2020/5/11 - 20:50
 * @version: 1.0
 * @website:
 */
public class AdminMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AdminMapper adminMapper;
    @Before
    public void init() {
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
            // 获得UserInfoMapper接口的代理对象
         adminMapper= sqlSession.getMapper(AdminMapper.class);
        }
    }

    /**
     * @description: 验证登录信息是否正确
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    @Test
    public void login(){

        // 直接调用接口的方法，查询编号为1的UserInfo对象
        LoginForm loginForm=new LoginForm();
        loginForm.setUsername("root");
        loginForm.setPassword("root");
        Admin admin = adminMapper.login(loginForm);
        if (admin!=null)
        {
            // 打印输出结果
            System.out.println("success");
            System.out.println(admin.toString());
        }
        else {
            System.out.println("未找到");
        }
    }

    /**
     * @description: 通过姓名查询指定管理员信息
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    @Test
    public void findByName() {
        // 直接调用接口的方法，查询编号为1的UserInfo对象
        Admin admin = adminMapper.findByName("root");
        if (admin!=null)
        {
            // 打印输出结果
            System.out.println(admin.toString());
        }
        else {
            System.out.println("未找到");
        }
    }

//
//    /**
//     * @description: 添加管理员信息
//     * @param:
//     * @date: 2020/5/11 - 20:24
//     * @return:
//     */
//    int insert(Admin admin);
//
//    /**
//     * @description: 根据姓名查询指定/所有管理员信息列表
//     * @param:
//     * @date: 2020/5/11 - 20:25
//     * @return:
//     */
//    List<Admin> selectList(Admin admin);
//
//    /**
//     * @description: 根据id更新指定管理员信息列表
//     * @param:
//     * @date: 2020/5/11 - 20:26
//     * @return:
//     */
//    int update(Admin admin);
//
//    /**
//     * @description: 根据id修改指定管理员密码
//     * @param:
//     * @date: 2020/5/11 - 20:27
//     * @return:
//     */
//    int updatePassword(Admin admin);
//
//    /**
//     * @description:  根据id删除指定管理员信息
//     * @param:
//     * @date: 2020/5/11 - 20:29
//     * @return:
//     */
//    int deleteById(Integer[] ids);

    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }




}